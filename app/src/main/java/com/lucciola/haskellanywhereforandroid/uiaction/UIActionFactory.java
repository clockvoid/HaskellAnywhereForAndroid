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
            case 1: {
                result = new HaskellAction(action.getInputString(), action.getDocumentString(), view);
                break;
            }
            case 2: {
                result = new FunctionAction(action.getInputString(), action.getDocumentString(), view);
                break;
            }
            case 3: {
                result = new CommandAction(action.getInputString(), action.getDocumentString(), view);
                break;
            }
            case 4: {
                result = new InputListAction(action.getInputString(), action.getDocumentString(), view);
                break;
            }
        }
        return result;
    }
}
