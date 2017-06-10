package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls;

import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ContextVisible;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlLocation;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapper;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.ControlWrapperList;
import com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util.controls.interfaces.Label;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Иван on 17-Feb-17.
 */
public class DivList {

  private List<ControlWrapper> controls;

  public DivList(List<ControlWrapper> controls) {
    this.controls = controls;
  }

  public List<Label> getElements() {
    List<Label> elements = new ArrayList<>();

    for (ControlWrapper control : controls) {
      elements.add(new LabelElement(control));
    }
    return elements;
  }

  public static DivList getById(String id) {
    return get(ControlLocation.getById(id));
  }

  public static DivList getByName(String searchName) {
    return get(ControlLocation.getByName(searchName));
  }

  public static DivList getByCss(String cssSelector) {
    return get(ControlLocation.getByCss(cssSelector));
  }

  public static DivList getByXPath(String xpathExpression) {
    return get(ControlLocation.getByXPath(xpathExpression));
  }

  private static DivList get(ControlLocation controlLocation) {
    return new DivList(
            new ControlWrapperList(ContextVisible.get().getList(controlLocation)).getList());
  }
}
