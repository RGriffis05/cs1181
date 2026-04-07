Advanced GUI

    GridBagLayout

        Layout Manager
            Gives programmers control over the positioning and layout of GUI components within a JFrame or such containers.

        GridBagLayout
            Positions GUI components in a two-dimensional grid and is one of the layout managers supported by Java.
        
        Assigning a Layout Manager
            A programmer must assign a layout manager to the JFrame component before adding components and specifying their layout via the add() method. The statement frame.setLayout(new GridBagLayout()); utilizes JFrame's setLayout() method to set a GridBagLayout as the frame's layout manager.

        GridBagLayout Constraints
            The statement layoutConst = new GridBagConstraints(); creates a GridBagConstraints variable named layoutConst that a programmer can use to specify layout constraints.

        gridx, gridy
            Used to specify the location (i.e., row and column) of a component

            layoutConst.gridx = 10;
        
        Insets
            Used to specify the minimum pixel padding in all four cardinal directions between a component and the edge of its containing cell

            layoutConst.insets = new Insets(topPad, leftPad, botPad, rightPad);

        gridwidth, gridheight
            Used to specify the width (or height) of a component in number of cells

            layoutConst.gridwidth = 2;