package com.austin.downloader;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.Source;

public class DownloaderDemo extends Application {

	private Parent createContent() {
		VBox root = new VBox();
		root.setPrefSize(400, 600);
		
		TextField fieldURL = new TextField();
		root.getChildren().add(fieldURL);
		
		fieldURL.setOnAction(event -> {
			Task<Void> task = new DownloadTask(fieldURL.getText());
			ProgressBar progressBar = new ProgressBar();
			progressBar.setPrefWidth(350);
			progressBar.progressProperty().bind(task.progressProperty());
			root.getChildren().add(progressBar);
			
			fieldURL.clear();
			
			Thread thread = new Thread(task);
			thread.setDaemon(true);
			thread.start();
		});
		

		

		return root;
	}
	
	private class DownloadTask extends Task<Void> {

		private String url;
		
		public DownloadTask(String url) {
			this.url = url;
		}
		
		@Override
		protected Void call() throws Exception {
			String ext = url.substring(url.lastIndexOf("."), url.length());
			URLConnection connection = new URL(url).openConnection();
			
			long fileLength = connection.getContentLengthLong();
			
			try (InputStream is = connection.getInputStream();
					OutputStream os = Files.newOutputStream(Paths.get("downloadedfile" + ext))) {
				
				long nread = 0L;
				byte[] buf = new byte[8192];
				
				int n;
				while((n = is.read(buf)) > 0) {
					os.write(buf, 0, n);
					nread += n;
					
					this.updateProgress(nread, fileLength);
				}
			}
			
			return null;
		}
		
		@Override
		protected void failed() {
			// if something went wrong
			System.out.println("Something went wrong.");
		}
		
		@Override
		protected void succeeded() {
			// if everything went OK
			System.out.println("File downloaded!");
			System.exit(0);
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
