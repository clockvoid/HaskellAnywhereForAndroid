package com.lucciola.haskellanywhereforandroid.uiaction;

import android.app.Activity;

import com.lucciola.haskellanywhereforandroid.Action;
import com.lucciola.haskellanywhereforandroid.Model;

/**
 * Created by hiden on 2017/06/19.
 */

public class UIActionFactory {

    public static UIAction createUIAction(Action action, Model model, Activity activity) {
        UIAction result = null;
        switch (action.getMode()) {
            case 1: {
                result = new HaskellAction(action.getInputString(), action.getDocumentString(), model, activity);
                break;
            }
            case 2: {
                result = new FunctionAction(action.getInputString(), action.getDocumentString(), model, activity);
                break;
            }
            case 3: {
                result = new CommandAction(action.getInputString(), action.getDocumentString(), model, activity);
                break;
            }
            case 4: {
                result = new InputListAction(action.getInputString(), action.getDocumentString(), model, activity);
                break;
            }
        }
        return result;
    }
}
