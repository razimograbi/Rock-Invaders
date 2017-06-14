import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainMenuScreen;
import com.mygdx.game.tools.GameCamera;

public class MyGame2 extends Game {
	public SpriteBatch batch;
	public static final int WIDTH = 480;
	public static final int HEIGHT = 720;
	public boolean isMobile = false;
    public GameCamera cam;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        cam = new GameCamera(WIDTH , HEIGHT);

		if (Gdx.app.getType() == Application.ApplicationType.Android || Gdx.app.getType() == Application.ApplicationType.iOS){
			isMobile = true;
		}
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		batch.setProjectionMatrix(cam.combined());
        super.render();
	}
	@Override
    public void resize(int width , int height){
        cam.update(width , height);
		super.resize(width , height);
    }

}
