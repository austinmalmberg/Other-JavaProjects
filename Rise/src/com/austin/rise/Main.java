package com.austin.rise;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	public final int WIDTH = 480;
	public final int HEIGHT = 240;

	private VBox root;

	private HBox top;
	private Label state;
	private VBox timers;
	private Label t_session;
	private Label t_day;

	private HBox bottom;
	private Button inOut;
	private VBox dateTime;
	private Label dt_time;
	private Label dt_date;
	private Button sitStand;
	
	private MyTimer timer;
	private StateManager sm;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(createContent()));
		stage.sizeToScene();
		stage.setResizable(false);
		stage.show();
	}

	private void initObjects() {		
		root = new VBox();

		// top stuff
		top = new HBox();

		// left
		state = new Label();

		// right
		timers = new VBox();
		t_session = new Label();
		t_day = new Label();

		
		// bottom
		bottom = new HBox();

		// left
		inOut = new Button();

		// middle
		dateTime = new VBox();
		dt_time = new Label();
		dt_date = new Label();

		// right
		sitStand = new Button();
		
		timer = new MyTimer();
		sm = new StateManager();
	}

	private void applyObjectFormatting() {
		root.setPrefSize(WIDTH, HEIGHT);
		
		// TOP (2 panels)
		top.setPrefSize(WIDTH, HEIGHT / 2);

		// left -- sitting or standing indicator
		state.setPrefSize(top.getPrefWidth() / 2, top.getPrefHeight());
		state.setAlignment(Pos.CENTER);
		state.setFont(Font.font(40));

		// right -- session and day timer
		timers.setPrefSize(top.getPrefWidth() / 2, top.getPrefHeight());

		t_session.setPrefSize(timers.getPrefWidth(), timers.getPrefHeight() / 2);
		t_session.setFont(Font.font(20));

		t_day.setPrefSize(timers.getPrefWidth(), timers.getPrefHeight() / 2);
		t_day.setFont(Font.font(20));

		
		// BOTTOM (3 panels)
		bottom.setPrefSize(WIDTH, HEIGHT / 2);

		// left -- in/out button
		inOut.setPrefSize(bottom.getPrefWidth() / 3, bottom.getPrefHeight());
		inOut.setFont(Font.font(32));

		// middle -- date/time
		dateTime.setPrefSize(bottom.getPrefWidth() / 3, bottom.getPrefHeight());
		dateTime.setAlignment(Pos.CENTER);

		// right -- sit/stand button
		sitStand.setPrefSize(bottom.getPrefWidth() / 3, bottom.getPrefHeight());
		sitStand.setFont(Font.font(32));

	}

	private Parent createContent() {
		initObjects();
		applyObjectFormatting();
		
		updateUI();
		
		// top
		t_session.setText("Session: ");
		t_day.setText("Day: ");
		timers.getChildren().addAll(t_session, t_day);

		top.getChildren().addAll(state, timers);

		// bottom
		inOut.setOnAction(e -> {
			// if button is clicked, update the state, "in" (standing) or "out"
			if(sm.getState().equals(State.OUT))
				sm.setState(State.STANDING);
			else
				sm.setState(State.OUT);
			
			// then update the button text
			updateUI();
		});

		// PROBABLY WILL BE REMOVED (REDUNDANT)
		dt_time.setText("12:00:00 AM");
		dt_date.setText("Wednesday 07/06/2016");
		dateTime.getChildren().addAll(dt_time, dt_date);

		sitStand.setOnAction(e -> {
			// if button is clicked, update the state, "sitting" or "standing"
			if(sm.getState().equals(State.STANDING))
				sm.setState(State.SITTING);
			else
				sm.setState(State.STANDING);
			
			// update button text
			updateUI();
		});

		bottom.getChildren().addAll(inOut, dateTime, sitStand);

		root.getChildren().addAll(top, bottom);

		return root;
	}
	
	private void updateUI() {	
		state.setText(sm.getState().toString());
		
		timer.update(sm.getState());
		
		switch(sm.getState()) {
		case OUT:
			inOut.setText("In");
			sitStand.setText("-");
			break;
		case STANDING:
			inOut.setText("Out");
			sitStand.setText("Sit");
			
			t_session.setText(String.valueOf(timer.getTimeStanding()));
			break;
		case SITTING:
			inOut.setText("Out");
			sitStand.setText("Stand");
			
			t_session.setText(String.valueOf(timer.getTimeSitting()));
			break;
		default:
			System.out.println("Main.updateUI default case was called.");
		}
	}
}
