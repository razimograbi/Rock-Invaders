public class Bullet {
    public static final float Dy = 40;
    public static int SpeedBullet = 500;
    public static final int Width = 32;
    public static final int Hieght = 32;
    public boolean remove  = false;
    float x , y;
    IsToched toched;
    private static Texture texture;

    public Bullet(float x){
        this.x = x;
        this.y = Dy;
        SpeedBullet = 500;
        this.toched = new IsToched(x , y , Width , Hieght);
        if (texture == null){
            texture = new Texture("bullet_red_alt.png");
        }

    }
    public void update(float deltatime){
        y+=SpeedBullet*deltatime;
        if (y> MyGame2.HEIGHT){
            remove = true;
        }
        toched.move(x , y);
    }
    public void render (SpriteBatch batch){
        batch.draw(texture , x , y);
    }

    public IsToched getToched (){
        return toched;
    }
}
