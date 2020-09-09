package root.system;

import java.util.logging.Logger;
import root.component.Attacker;
import root.entity.Entity;

/**
 * @author ron 2020/9/9
 */
public class AttackSystem {

  private static final Logger LOGGER = Logger.getLogger("AttackSystem");

  /**
   * 执行攻击的动作
   *
   * @param attacker   攻击人
   * @param beAttacker 被攻击人
   */
  public void attack(Entity attacker, Entity beAttacker) {
    final Attacker component = attacker.get(Attacker.class);
    if (component == null) {
      throw new SystemException("attacker is null");
    }
    final Attacker beComponent = beAttacker.get(Attacker.class);
    if (beComponent == null) {
      throw new SystemException("be attacker is null");
    }

    for (Attacker one : new Attacker[]{component, beComponent}) {
      if (!isAlive(one)) {
        throw new SystemException(String.format("%s已经死了, 请不要再鞭尸。", one.name));
      }
    }

    beComponent.blood -= component.aggressive;
    LOGGER.info(String.format("%s向%s发起攻击，造成了%d点伤害。",
        component.name, beComponent.name, component.aggressive));
  }

  boolean isAlive(Attacker attacker) {
    return attacker.blood > 0;
  }
}
