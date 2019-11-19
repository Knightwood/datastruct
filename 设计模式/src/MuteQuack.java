public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        //Mute 静音
        System.out.println("<< Silence >>");
    }
}
