


public class DashboardForm {
    
    
    private JFrame frame;
    private JPanel titleBar;
    private JLabel titleLabel;
    private JLabel closeLabel;
    private JLabel minimizeLabel;
    private JPanel dashboardPanel;
    
    // dragging the form
    private boolean isDragging = false;
    private Point mouseOffset;
    
    public DashboardForm()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        
        // Set the custom rounded border to the form
        frame.getRootPane().setBorder(BorderFactory.createCompoundBorder(
        
                new RoundedBorder(10, new Color(255,204,0)),
                new EmptyBorder(0, 0, 0, 0)
                
        ));
        
        
        titleBar = new JPanel();
        titleBar.setLayout(null);
        titleBar.setBackground(Color.DARK_GRAY);
        titleBar.setPreferredSize(new Dimension(frame.getWidth(), 30));
        frame.add(titleBar, BorderLayout.NORTH);

        titleLabel = new JLabel("Dashboard");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(10, 0, 200, 30);
        titleBar.add(titleLabel);

        closeLabel = new JLabel("X");
        closeLabel.setForeground(Color.WHITE);
        closeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        closeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeLabel.setBounds(frame.getWidth() - 50, 0, 30, 30);

        closeLabel.addMouseListener(new MouseAdapter() {
            // close the login form
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            // mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                closeLabel.setForeground(Color.ORANGE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeLabel.setForeground(Color.WHITE);
            }

        });

        titleBar.add(closeLabel);

        minimizeLabel = new JLabel("-");
        minimizeLabel.setForeground(Color.WHITE);
        minimizeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        minimizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        minimizeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeLabel.setBounds(frame.getWidth() - 80, 0, 30, 30);

        minimizeLabel.addMouseListener(new MouseAdapter() {
            // iconify (minimize) the login form
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setState(JFrame.ICONIFIED);
            }

            // mouse hover effect
            @Override
            public void mouseEntered(MouseEvent e) {
                minimizeLabel.setForeground(Color.ORANGE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minimizeLabel.setForeground(Color.WHITE);
            }

        });

        titleBar.add(minimizeLabel);

        
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        dashboardPanel.setBackground(new Color(240,240,240));
        frame.add(dashboardPanel,BorderLayout.CENTER);
        
        
        // add data
        addDatePanel("Sales", "$500k");
        addDatePanel("Expenses", "$350k");
        addDatePanel("Profit", "$150k");
        addDatePanel("Customers", "1,000");
        
        // draw chart
        JPanel chartPanel = new JPanel(){
        
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                // draw chart
                drawChart(g, getHeight());
            }
            
        };

        
        chartPanel.setLayout(new BorderLayout());
        chartPanel.setPreferredSize(new Dimension(740,300));
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setBorder(new LineBorder(Color.GRAY, 1));
        
        // the chart title
        JLabel chartTitleLabel = new JLabel("Orders");
        chartTitleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        chartTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chartTitleLabel.setOpaque(true);
        chartTitleLabel.setBackground(new Color(150,50,50));
        chartTitleLabel.setForeground(Color.WHITE);
        chartPanel.add(chartTitleLabel,BorderLayout.NORTH);
        dashboardPanel.add(chartPanel);
        
        
        
        
        // Mouse listener for window dragging
        titleBar.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                isDragging = true;
                mouseOffset = e.getPoint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                isDragging = false;

            }

        });

        // Mouse motion listener for window dragging
        titleBar.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDragging) {
                    // When the mouse is dragged, this event is triggered

                    // Get the current location of the mouse on the screen
                    Point newLocation = e.getLocationOnScreen();

                    // Calculate the new window location by adjusting for the initial mouse offset
                    newLocation.translate(-mouseOffset.x, -mouseOffset.y);

                    // Set the new location of the main window to achieve dragging effect
                    frame.setLocation(newLocation);
                }
            }

        });

        
        frame.setVisible(true);
    }
    
    
    // create a method to add data to the panel
    private void addDatePanel(String title, String value)
    {
        JPanel dataPanel = new JPanel(){
        
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                // draw the data panel
                drawDataPanel(g, title, value, getWidth(), getHeight());
            }
            
        };
        
        dataPanel.setLayout(new GridLayout(2, 1));
        dataPanel.setPreferredSize(new Dimension(170,100));
        dataPanel.setBackground(new Color(255,255,255));
        dataPanel.setBorder(new LineBorder(new Color(255,204,0), 5));
        dashboardPanel.add(dataPanel);
        
    }

    
    // Create a Custom method to draw a data panel
    private void drawDataPanel(Graphics g, String title, String value, int width, int height){
        
        Graphics2D g2d = (Graphics2D) g;
        
        // Customize the data panel appearance here
        g2d.setColor(new Color(255,255,255));
        g2d.fillRoundRect(0, 0, width, height, 20, 20);
        
        // Stylish background color for Data Panel Title
        g2d.setColor(new Color(150,50,50));
        g2d.fillRect(0, 0, width, 40);
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        g2d.drawString(title, 20, 30);
        
        // value
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial",Font.BOLD,16));
        g2d.drawString(value, 20, 75);
    }
    
    
    // Create a Custom method to draw a chart
    private void drawChart(Graphics g, int height)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        // Customize the chart appearance here
        int barWidth = 60;
        int barSpacing = 55;
        int startX = 50;
        int starY = height - 80;
        
        // Sample data values 
        int[] data = {100,200,150,300,250,350};
        
        // Calculate maximum data value for scaling
        int maxDataValue = 0;
        for(int value : data)
        {
            if(value > maxDataValue)
            {
                maxDataValue = value;
            }
        }
        
        // Set colors for bars and labels
        Color barColor = new Color(76, 175, 80);
        Color labelColor = Color.BLACK;
        
        // Draw the bars and labels
        for(int i = 0; i < data.length; i++)
        {
            int barHeight = (int)((double)data[i]/maxDataValue*(starY-60));
            int x = startX + (barWidth + barSpacing) * i;
            int y = starY - barHeight;
            g2d.setColor(barColor);
            g2d.fillRect(x, y, barWidth, barHeight);
            
            // Draw data labels
            g2d.setColor(labelColor);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString(String.valueOf(data[i]), x + 10, y - 10);
            
            // Draw product labels (e.g., "Product 1", "Product 2", etc.)
            g2d.setFont(new Font("Arial", Font.PLAIN, 12));
            g2d.drawString("Product " + (i + 1), x + 5, starY + 20);
        }
        
        
    }
    
    
    public static void main(String[] args) {
        new DashboardForm();
    }
}

// Create a Custom Border class for rounded corners
class RoundedBorder implements Border
{
    
    private int radius;
    private Color color;
    
    public RoundedBorder(int radius, Color color){
        this.color = color;
        this.radius = radius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);
        g2d.drawRoundRect(x, y, width-1, height-1, radius, radius);
        
    }

    @Override
    public Insets getBorderInsets(Component c) {
    
        return new Insets(radius, radius, radius, radius);
        
    }

    @Override
    public boolean isBorderOpaque() {
    
        return true;
        
    }
    
}
