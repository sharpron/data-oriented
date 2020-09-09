package root.component;

/**
 * @author ron 2020/9/9
 */
public class Attacker implements Component {

  public String name;

  public int blood;

  public int radius;

  public int aggressive;

  public Attacker(
      String name,
      int blood,
      int radius,
      int aggressive) {
    this.name = name;
    this.blood = blood;
    this.radius = radius;
    this.aggressive = aggressive;
  }
}
