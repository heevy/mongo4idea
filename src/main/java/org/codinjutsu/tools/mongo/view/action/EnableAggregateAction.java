/*
 * Copyright (c) 2013 David Boissier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codinjutsu.tools.mongo.view.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ToggleAction;
import org.codinjutsu.tools.mongo.utils.GuiUtils;
import org.codinjutsu.tools.mongo.view.QueryPanel;

import javax.swing.*;

public class EnableAggregateAction extends ToggleAction {

    private static final Icon AGGREGATION_ICON = GuiUtils.loadIcon("table_multiple.png");

    private final QueryPanel queryPanel;

    private boolean enableAggregation = true;

    public EnableAggregateAction(final QueryPanel queryPanel) {
        super("Enable aggregation", "toggle find/aggregation", AGGREGATION_ICON);
        this.queryPanel = queryPanel;
    }


    @Override
    public boolean isSelected(AnActionEvent anActionEvent) {
        return enableAggregation;
    }

    @Override
    public void setSelected(AnActionEvent anActionEvent, boolean enableAggregation) {
        this.enableAggregation = enableAggregation;
        if (enableAggregation) {
            queryPanel.toggleToAggregation();
        } else {
            queryPanel.toggleToFind();
        }
    }
}
