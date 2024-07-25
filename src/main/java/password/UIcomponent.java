package password;

import javax.swing.*;
import java.awt.*;

public class UIcomponent {

    public static Font getPlainFont()
    {
        return new Font("System",Font.PLAIN,20);
    }

    public static void Comp(Component c, int x, int y)
    {
        c.setFont(getPlainFont());
//        c.setBackground(Color.WHITE);
        c.setForeground(Color.BLACK);
        c.setBounds(x,y,300,40);
    }

}
