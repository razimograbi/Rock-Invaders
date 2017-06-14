public class GameCamera {
    private OrthographicCamera cam;
    private StretchViewport viewport;
    public GameCamera(int width , int height){
        cam = new OrthographicCamera();
        viewport = new StretchViewport(width ,height , cam);
        viewport.apply();
        cam.position.set(width / 2 , height / 2 , 0);
        cam.update();
    }
    public Matrix4 combined(){
        return cam.combined;
    }
    public void update(int width , int height){
        viewport.update(width , height);
    }
    //where is the person clicking
    public Vector2 getInputInGameWorld(){
        Vector3 inputScreen = new Vector3(Gdx.input.getX() ,Gdx.graphics.getHeight() - Gdx.input.getY() , 0);
        Vector3 unprojected = cam.unproject(inputScreen);
        return new Vector2(unprojected.x , unprojected.y);
    }
}
