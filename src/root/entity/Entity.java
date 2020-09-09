package root.entity;

import java.util.HashMap;
import java.util.Map;
import root.component.Component;

/**
 * @author ron 2020/9/9
 */
public class Entity {

  private Map<Class<? extends Component>, Component> components = new HashMap<>();

  @SuppressWarnings("unchecked")
  public <T extends Component> T get(Class<T> clazz) {
    return (T) components.get(clazz);
  }

  public void add(Component component) {
    if (components.containsKey(component.getClass())) {
      throw new IllegalArgumentException("repeat add!");
    }
    components.put(component.getClass(), component);
  }

}
