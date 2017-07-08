 public class MainMenuScreen implements Screen {
    private static final int EXIT_BUTTON_WIDTH = 250;
    private static final int EXIT_BUTTON_HEIGHT = 120;
    private static final int PLAY_BUTTON_wIDTH = 300;
    private static final int PLAY_BUTTON_HEIGHT = 120;
    private static final int EXIT_BUTTON_Y = 100;
    private static final int PLAY_BUTTON_Y = 230;
    private BitmapFont highscore;
    MyGame2 game;
    public static Music music;

    Texture PlayButtonActive;
    Texture img;
    Texture PlayButtonInactive;
    Texture ExitButtonActive;
    Texture ExitButtonInactive;

    public MainMenuScreen(MyGame2 game){
        this.game = game;
        highscore = new BitmapFont();
        music = Gdx.audio.newMusic(Gdx.files.internal("10-escape-from-the-city-instrumental-.mp3"));
        music.setLooping(true);
        music.setVolume(0.6f);
        music.play();
        highscore.getData().setScale(3,3);
        img = new Texture("video-game-background-1405076_960_720.png");
        PlayButtonActive = new Texture("play_button_active121.png");
        PlayButtonInactive = new Texture("play_button_inactive.png");
        ExitButtonActive = new Texture("exit_button_active.png");
        ExitButtonInactive = new Texture("exit_button_inactive.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        music.play();
        game.batch.begin();
        game.batch.draw(img , 0 , 0);
        int middle = MyGame2.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
        if (game.cam.getInputInGameWorld().x < middle + EXIT_BUTTON_WIDTH && game.cam.getInputInGameWorld().x > middle && MyGame2.HEIGHT - game.cam.getInputInGameWorld().y < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && MyGame2.HEIGHT - game.cam.getInputInGameWorld().y > EXIT_BUTTON_Y) {
            game.batch.draw(ExitButtonActive, middle, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {
                Gdx.app.exit();
            }

        }else {
            game.batch.draw(ExitButtonInactive , middle , EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH , EXIT_BUTTON_HEIGHT);
        }
        middle = MyGame2.WIDTH / 2 - PLAY_BUTTON_wIDTH / 2;
        if (game.cam.getInputInGameWorld().x < middle + PLAY_BUTTON_wIDTH && game.cam.getInputInGameWorld().x > middle && MyGame2.HEIGHT - game.cam.getInputInGameWorld().y < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && MyGame2.HEIGHT - game.cam.getInputInGameWorld().y > PLAY_BUTTON_Y) {
            game.batch.draw(PlayButtonActive, middle, PLAY_BUTTON_Y, PLAY_BUTTON_wIDTH, PLAY_BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {
                this.dispose();
                music.play();
                game.setScreen(new MainGameScreen(game));
            }

        }else {
            game.batch.draw(PlayButtonInactive, middle, PLAY_BUTTON_Y , PLAY_BUTTON_wIDTH , PLAY_BUTTON_HEIGHT);
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
