/*
 * Copyright (c) 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasologylauncher.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * A JLabel used as background image for launcher.
 *
 * @author Skaldarnar
 */
public class BackgroundImage extends JLabel {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(BackgroundImage.class);

    public BackgroundImage(final int width, final int height) {
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(0, 0, width, height);

        InputStream stream = null;
        BufferedImage bg;

        try {
            stream = BackgroundImage.class.getResourceAsStream("/org/terasologylauncher/images/background.png");
            bg = ImageIO.read(stream);
            //TODO: Apply blur filter
        } catch (IOException e) {
            logger.error("Could not read background image.", e);
            bg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }

        setIcon(new ImageIcon(bg.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        setVerticalAlignment(SwingConstants.TOP);
        setHorizontalAlignment(SwingConstants.LEFT);
    }
}
