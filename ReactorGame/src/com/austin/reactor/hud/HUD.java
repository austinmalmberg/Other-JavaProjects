package com.austin.reactor.hud;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HUD extends VBox {

	public static final int WIDTH = 235;
	public static final int HEIGHT = 115;
	
	// resources
	private IntegerProperty money;
	private IntegerProperty research;
	private IntegerProperty power;	// power stored in batteries
	private IntegerProperty max_power;	// maximum battery power
	
	// resource changes
	private IntegerProperty dMoney;
	private IntegerProperty dResearch;
	private IntegerProperty dPower;
	
	// text fields for integer variables
	private Text moneyText;
	private Text researchText;
	private Text powerText;
	private Text maxPowerText;
	
	public HUD() {
		setPrefSize(WIDTH, HEIGHT);
		setStyle("-fx-background-color: darkgray");
		
		money = new SimpleIntegerProperty(1);
		research = new SimpleIntegerProperty(0);
		power = new SimpleIntegerProperty(0);
		max_power = new SimpleIntegerProperty(0);
		
		dMoney = new SimpleIntegerProperty(0);
		dResearch = new SimpleIntegerProperty(0);
		dPower = new SimpleIntegerProperty(0);
		
		moneyText = new Text();
		bindText("Money: ", moneyText, money, dMoney);
		
		researchText = new Text();
		bindText("Research: ", researchText, research, dResearch);
		
		powerText = new Text();
		bindText("Power: ", powerText, power, dPower);
		
		maxPowerText = new Text();
		bindText("Max Power: ", maxPowerText, max_power, null);
		
		getChildren().addAll(moneyText, researchText, powerText, maxPowerText);
	}
	
	private void bindText(String s, Text text, IntegerProperty integerProperty1, IntegerProperty integerProperty2) {
		text.setFont(Font.font(12));
		text.setTranslateX(10);
		text.setTranslateY(text.getTranslateY() + 8);
		
		text.textProperty().bind(new StringBinding() {
			{
				bind(integerProperty1);
			}
			
			@Override
			protected String computeValue() {
				if(integerProperty2 == null) {
					return s + integerProperty1.get();
				} else {
					return s + integerProperty1.get() + " +" + integerProperty2.get();
				}
			}
		});
	}
	
	public void tick() {
		money.add(dMoney);
		research.add(dResearch);
		power.add(dPower);
	}
	
	public void changeMoney(int i) { money.add(i); }
	public void changeResearch(int i) { research.add(i); }
	public void changePower(int i) { power.add(i); }
	public void changeMaxPower(int i) { max_power.add(i); }
}
