Graphical User Interface (GUI)

    Frame Windows
        
        Frame
            A window with a border and a title bar, to create a frame you will do these lines of code

            Displaying a Frame:
                
                JFrame frame = new JFrame("An empty frame"); This creates the frame (this makes the title "An empty frame")
                frame.setSize(300, 300); this makes the frame 300 pixels wide by 300 pixels tall
                frame.setTitle("An empty frame"); This line can be used to create the frame's titl. If you do create the title in the constructor, and still call this line, it will override the original title.
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); This line ensures the program ends if the GUI is closed.
                frame.setVisible(true); This makes the frame visible.

        Panel
            A user-interface component with no visual appearance. It can be used to group other components.
                
                JPanel panel = new JPanel();
                panel.add(button);
                panel.add(label);
                frame.add(panel);
            
        Using Inheritance to Customize Frames
            You are able to use inheritance to make your frame code easier to read. You can store variables such as button or label as an instance variable and then initialize them in the constructor of the subclass. This makes it easier to organize the code and add helper methods easier.

        Events and Event Handling

            User-Interface Event
                A notification to a program that a user action such as a key press, mouse move, or menu selection has occured.

            Event Listener
                An object that is notified by an event source when an event occurs.

            Event Source
                A user-interface component, such as a button, that generates a partocular event. It is an object that can notify other classes of an event.

            Using Inner Class for Listeners
                Inner Class
                    A class that is defined inside another class
                
                    There are two advantages to making a listener class into an inner class. First, listener classes tend to be very short. You can put the inner class close to where it is needed, without cluttering up the remainder of the project. Moreover, inner classes have a very attractive feature. Their methods can access instance variable and methods of the surrounding code. This is useful when implementing event handlers. It allows the inner class to access variables without having to received them as constructor or method arguments

        Annonymus Inner Classes

            These are very useful, because it saves you the trouble of having to type extra code for something that may only be used once, for example instead of:
                
                String buttonLabel = "Add Interest";
                JButton button = new JButton(buttonLabel);
                
            You can do this instead:
                
                JButton button = new JButton("Add Interest");
            
            The "Add Interest" is an ANONYMOUS OBJECT

        Lambda Expressions for Event Handling
        
            Instead of declaring a ClickListener class and adding an instance as a listener to a button, you can simply add the listener as follows:

                button.addActionListener((ActionEvent event) -> System.out.println("I was clicked."));
            
        Processing Text Input
            A graphical application can receive text input by calling the "showInputDialog" method of the "JOptionPane" class, but popping up a separate dialog box for each input is not a natural user interface.

            Text Fields
                The "JTextField" class provides a text field for reading a single line of text. When you construct a text field, you need to supply the width - the approximate number of characters that you expect the user to type:

                    final int FIELD_WIDTH = 10;
                    rateField = new JTextField(FIELD_WIDTH);

                Users can tyope additonal characters, but then a part of the contents of the field become invisible.

            Text Areas
                A text field holds a single line of text. To display multiple lines of text, use the "JTextArea" class. When constructing a text area, you can specify the number of rows and columns:
                    
                    final int ROWS = 10; Lines of text
                    final int COLUMNS = 30; Characters in each row
                    JTextArea textArea = new JTextArea(ROWS, COLUMNS);

                Use the "setText" method to set the text opf a text field or text area. The append method adds text to the end of a text area. Use newline characters to seperate lines, like this:
                    
                    textArea.append(balance + "\n");
                
                Using the "setEditable" method can make it so the text field or text area is for display purposes only, used like:
                    textArea.setEditable(false);
                
                To add scroll bars to a text area, use a JScrollPane, like this:
                    
                    JTextArea textArea = new JTextArea(ROWS, COLUMNS);
                    JScrollPane scrollPane = new JScrollPane(textArea);
        
        Create Drawings
            You often want to include simple drawings such as graphs or charts in your programs. The Java library does not have any standard components for this purpose, but it is fairly easy to make your own drawings.

                Drawing on a Component
                    You can not draw directly onto a frame. Instead, you add a component to the frame and draw on the component. To do this, you must extend the "JComponent" class and override its "paintComponent" method.
                    
                        public class ChartComponent extends JComponent{
                            @Override
                            public void paintComponent(Graphics g){
                                drawing instructions
                            }
                        }

                    When the component is shown for the first time, its "paintComponent" metyhod is called automatically. The method is also called when the window is resized, or when it is hsown again after it was hidden.
                    The "paintComponent" method receives an object of type Graphics. The "Graphics" object stores the graphics state - current color, font, and so on, that are used for drawing operations. The "Graphics" class has methods for drawing geometric shapes. The call:
                    
                        g.fillRect(x, y, width, height);

                    draws a solid rectangle with upper-left corner (x, y) and the given width and height. If you call the "drawRect" method, you obtain the outline of the rectangle instead, without having the interior filled.
                    THE COORDINATES SYSTEM IS DIFFERENT THAN THE ONE USED IN MATHEMATICS. THE ORIGIN IS AT THE UPPER-LEFT CORNER OF THE COMPONENT, AND THE Y-COORDINATE GROWS DOWNWARD.

                Ovals, Lines, Text, and Color
                    To draw an oval, you specify its bounding box in the same way you would specify a rectangle, namely by the x- and y- coordinates of the top-left corner and the width and height of the box. Then call:
                    
                        g,drawOval(x, y, width, height);
                    
                    draws the outline of an oval. To draw a circle, simply set the width and height to the same values:

                        g,drawOval(x, y, diamtere, diameter);

                    if you want to fill the inside of the oval, use the "fillOval" method instead. Conversely, if you want only the outline of a rectangle, with no filling, use the "drawRect" method.
                    To draw a line, call the "drawLine" method with the x- and y- coordinates of both end points:

                        g.drawLine(x1, y1, x2, y2);

                    You often want to put text inside a drawing, for example, to label some of the parts. Use the "drawString" method of the "Graphics" class to draw a strong anywhere in a window. You must specify the string and the x- and y-coordinates of the basepoint of the first character in the string. For example:

                        g.drawString("Message", 50, 100);

                    When you first start drawing, all shapes and strings are drawn with a black pen. To change the color, you need to supply an ibject of type "Color". Java uses the RGB color model. That is, specify a color by the amounts of primary colors-red, green, and blue-that make up the color. The amounts are given as integers between 0 (primary color not present) and 255 (maximum amount present). For example:

                        Color magenta = new Color(255, 0, 255);

                    construts a "color" object with maximum red, no green, and maximum blue, yielding a bright purple color called magenta.
                    For convenience, a variety of colors have been predefined in the "Color" class. For example, Color.PINK has been predefined to be the same color as new Color(255, 175, 175).
                    To Draw a shape in different colors, first set the color of the "Graphics" object, the call the drawing method:

                        g.setColor(Color.YELLOW);
                        g.fillOval(350, 25, 35, 20); Fills the oval in yellow