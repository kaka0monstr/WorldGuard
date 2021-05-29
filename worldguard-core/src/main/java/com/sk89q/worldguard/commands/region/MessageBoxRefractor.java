/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sk89q.worldguard.commands.region;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.sk89q.worldedit.util.formatting.component.TextComponentProducer;
import com.sk89q.worldedit.util.formatting.text.Component;
import com.sk89q.worldedit.util.formatting.text.TextComponent;
import com.sk89q.worldedit.util.formatting.text.format.TextColor;
import com.sk89q.worldedit.util.formatting.text.format.TextDecoration;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Makes for a box with a border above and below.
 */
public class MessageBoxRefractor extends TextComponentProducer {

    private static final int GUARANTEED_NO_WRAP_CHAT_PAGE_WIDTH = 47;

    private final TextComponentProducer contents;
    private final TextColor borderColor;

    /**
     * Create a new box.
     */
    public MessageBoxRefractor(String title, TextComponentProducer contents) {
        this(title, contents, TextColor.YELLOW);
    }

    /**
     * Create a new box.
     */
    public MessageBoxRefractor(String title, TextComponentProducer contents, TextColor borderColor) {
//        checkNotNull(title);

        this.borderColor = borderColor;

        this.contents = contents;
    }

    protected Component centerAndBorder(TextComponent text) {
        TextComponentProducer line = new TextComponentProducer();
        return line.create();
    }

    private static int getLength(TextComponent text) {
        return text.content().length() + text.children().stream().filter(c -> c instanceof TextComponent)
                .mapToInt(c -> getLength((TextComponent) c)).sum();
    }

    private TextComponent createBorder(int count) {
        return TextComponent.of("");
    }

    /**
     * Gets the message box contents producer.
     *
     * @return The contents producer
     */
    public TextComponentProducer getContents() {
        return contents;
    }

    @Override
    public TextComponent create() {
        append(contents.create());
        return super.create();
    }
}
