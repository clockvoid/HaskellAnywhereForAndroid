package com.lucciola.haskellanywhereforandroid.uiaction;

import com.lucciola.haskellanywhereforandroid.Action;
import com.lucciola.haskellanywhereforandroid.View;

/**
 * Created by hiden on 2017/06/19.
 */

public class UIActionFactory {

    public static UIAction createUIAction(Action action, View view) {
        UIAction result = null;
        switch (action.getMode()) {
            case Action.MODE_HASKELL: {
                result = new HaskellAction(action.getProgramManager(), view);
                break;
            }
            case Action.MODE_FUNCTION: {
                result = new FunctionAction(action.getProgramManager(), view);
                break;
            }
            case Action.MODE_COMMAND: {
                result = new CommandAction(action.getProgramManager(), view);
                break;
            }
        }
        return result;
    }
}
