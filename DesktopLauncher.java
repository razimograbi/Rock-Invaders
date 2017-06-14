public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = MyGame2.WIDTH;
		config.height = MyGame2.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new MyGame2(), config);
	}
}
