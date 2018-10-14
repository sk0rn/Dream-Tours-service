package utils;

import java.util.List;
import java.util.function.Function;

public class DropDownHtmlCompiler {

    public <T> String compileDropDown(List<T> subjects, Function<T, Object[]> getParams, String textTarget, String idTarget) {
        if (subjects == null) {
            return "<a class='dropdown-item' href='#'>Пусто</a>";
        } else {
            String result = "";
            Object[] params;

            for (T object : subjects) {
                params = getParams.apply(object);
                result += String.format("<a class='dropdown-item' href='#' onclick=\"onOptionClick('%s', '%s', '%s', %s)\">%s</a>%n",
                        textTarget, params[1], idTarget, params[0], params[1]);
            }
            return result;
        }
    }
}
