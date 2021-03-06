package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyMainGame;


public class TitleScreen extends PrototypeScreen {

    public TitleScreen(Game aGame) {
        game = aGame;
        stage = new Stage(new ScreenViewport());
               
        //background
        Texture texture = new Texture(Gdx.files.internal("img/cover5.jpg"));
        Image image1 = new Image(texture);
        image1.setPosition(0,0);
        image1.setSize(500,500);
        stage.addActor(image1);

        //created button
        TextButton startButton, exitButton, optionButton;

        startButton = new TextButton("START", MyMainGame.gameSkin);
        startButton.setSize(250,100);
        startButton.setPosition(120,300);
        
        optionButton = new TextButton("OPTION", MyMainGame.gameSkin);
        optionButton.setSize(250,100);
        optionButton.setPosition(120,180);
        
        exitButton = new TextButton("EXIT", MyMainGame.gameSkin);
        exitButton.setSize(250,100);
        exitButton.setPosition(120,60);

        //add listener
        startButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new VocabScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        optionButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new OptionScreen(game));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
    
        stage.addActor(startButton);
        stage.addActor(optionButton);        
        stage.addActor(exitButton);
    }

	@Override
	public boolean keyDown(int keycode) {
		 if(keycode == Input.Keys.ESCAPE){
	            //popup
                Window window = new Window("Question ?", MyMainGame.gameSkin);
    	        window.setSize(350f, 150.0f);
    	        window.setPosition(70, 220);
    	        window.getTitleLabel().setAlignment(Align.center);
    	        
    	        Label label = new Label("               Would you like to exit ?", MyMainGame.gameSkin);
    	        window.add(label).padTop(20);
    	  
    	        window.row();
    	        TextButton textButton1 = new TextButton("Yes", MyMainGame.gameSkin, "small");
    	        window.add(textButton1).expandX().padTop(10.0f).padRight(20);
    	        
    	        TextButton textButton = new TextButton("No", MyMainGame.gameSkin, "small");
    	        window.add(textButton).expandX().padTop(10.0f).padRight(150f);
    	        
                 stage.addActor(window);
                 textButton1.addListener(new InputListener(){
                     @Override
                     public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    	 Gdx.app.exit();
                     }
                     @Override
                     public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                         return true;
                     }
                 });
                 textButton.addListener(new InputListener(){
                     @Override
                     public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    	 window.remove();
                     }
                     @Override
                     public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                         return true;
                     }
                 });
	            
		 }
		return super.keyDown(keycode);
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return super.keyUp(keycode);
	}
}
