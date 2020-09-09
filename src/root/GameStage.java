package root;

import root.component.Attacker;
import root.entity.Entity;
import root.system.AttackSystem;

/**
 * @author ron 2020/9/9
 */
public class GameStage {

  public static void main(String[] args) {
    final Entity altman = new Entity();
    altman.add(new Attacker("迪迦", 1000, 200, 150));

    final Entity monster = new Entity();
    monster.add(new Attacker("巴顿", 10000, 100, 120));

    final AttackSystem attackSystem = new AttackSystem();

    while (true) {
      if (Math.random() > 0.5) {
        attackSystem.attack(altman, monster);
      } else {
        attackSystem.attack(monster, altman);
      }
    }
  }
}
