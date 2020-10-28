package robo1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 3
 *
 * @author BAHARAN1
 */
public class gamepanel2 extends JPanel implements KeyListener, Runnable, MouseMotionListener, MouseListener {

    InputStream input;
    OutputStream output;
    Socket socket;
    String a1 = "1";
    double aDouble = 0;
    ImageIcon enemy = new ImageIcon("Enemy1.png");
    double x = 502, y = 365, sX, sY, xt, yt, a, b, makhraj, sx, sy,x2=500,y2=300,sX2,sY2,xt2,yt2,sx2,sy2,a2,b2;
    ImageIcon icon;
    JButton aa = new JButton();
    JLabel image = new JLabel(icon);
    ImageIcon bb1 = new ImageIcon("robo.png");
    ImageIcon bb2 = new ImageIcon("tir.png");
    ImageIcon bb3 = bb1;
    ImageIcon c = new ImageIcon("tir.png");
    int shelik = 0,shelik2;
    ArrayList<String> backgrounds;
    String back1 = "background1.jpg";
    String back2 = "background2.jpg";
    String back3 = "background4.jpg";
    String back4;
    String back;
    int numback = 1;
    Random r = new Random();
    Enemy enemy1;
    Enemy enemy2;
    Enemy enemy3;
    Enemy enemy4;
    Enemy enemy5;
    Enemy enemy6;
    Enemy enemy7;
    Enemy enemy8;
    Enemy enemy9;
    Enemy enemy10;
    Enemy enemy11;
    Enemy enemy12;
    Enemy enemy13;
    Enemy enemy14;
    Enemy enemy15;
    ArrayList<Enemy> enemysl1;
    ArrayList<Enemy> enemysl2;
    ArrayList<Enemy> enemysl3;
    ArrayList<Enemy> enemysl4;
    ArrayList<ArrayList<Enemy>> levelenemys;
    int win = 0;
    int shelikcounter;
    int[] t = new int[10];
    int[] enhedam = new int[10];
    int check;
    int lives = 3,lives2=3;
    int level = 1;
    String[] sep;
    ImageIcon boxa = new ImageIcon("box.png");
    ImageIcon boxb = new ImageIcon("money.png");
    ImageIcon box1 = boxa;

    public gamepanel2() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), 4000);
        input = socket.getInputStream();
        output = socket.getOutputStream();
        backgrounds = new ArrayList<String>();
        backgrounds.add("  ");
        backgrounds.add("background1.jpg");
        backgrounds.add("background2.jpg");
        backgrounds.add("background3.png");
        backgrounds.add("background4.jpg");
        icon = new ImageIcon("background1.jpg");
        image.setIcon(icon);
        aa.addKeyListener(this);
        image.addMouseListener(this);
        image.addMouseMotionListener(this);
        this.add(aa);
        this.add(image);
        aa.setSize(0, 0);
        enemysl1 = new ArrayList<Enemy>();
        enemysl2 = new ArrayList<Enemy>();
        enemysl3 = new ArrayList<Enemy>();
        enemysl4 = new ArrayList<Enemy>();
        levelenemys = new ArrayList<ArrayList<Enemy>>();
        (new Thread(this)).start();
        enemy1 = new Enemy();
        enemy2 = new Enemy();
        enemy3 = new Enemy();
        enemy4 = new Enemy();
        enemy5 = new Enemy();
        enemy6 = new Enemy();
        enemy7 = new Enemy();
        enemy8 = new Enemy();
        enemy9 = new Enemy();
        enemy10 = new Enemy();
        enemy11 = new Enemy();
        enemy12 = new Enemy();
        enemy13 = new Enemy();
        enemy14 = new Enemy();
        enemy15 = new Enemy();
        enemy1.xE = 550;
        enemy1.yE = 120;
        enemy2.xE = 460;
        enemy2.yE = 70;
        enemysl1.add(enemy1);
        enemysl1.add(enemy2);
        enemysl2.add(enemy3);
        enemysl2.add(enemy4);
        enemysl2.add(enemy5);
        enemysl3.add(enemy6);
        enemysl3.add(enemy7);
        enemysl3.add(enemy8);
        enemysl3.add(enemy9);
        enemysl3.add(enemy10);
        enemysl4.add(enemy11);
        enemysl4.add(enemy12);
        enemysl4.add(enemy13);
        enemysl4.add(enemy14);
        enemysl4.add(enemy15);
        levelenemys.add(enemysl1);
        levelenemys.add(enemysl2);
        levelenemys.add(enemysl3);
        levelenemys.add(enemysl4);
        JFrame mainFrame = new JFrame();
        mainFrame.setLocation(0, 0);
        mainFrame.setSize(1020, 780);
        mainFrame.add(this);
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) throws IOException {

        (new Thread(new gamepanel2())).start();

    }

    @Override
    public void paint(Graphics arg0) {
        super.paint(arg0);
        xt = Double.parseDouble(sep[0]);
        yt = Double.parseDouble(sep[1]);
        x = Double.parseDouble(sep[2]);
        y = Double.parseDouble(sep[3]);
        sX = Double.parseDouble(sep[4]);
        sY = Double.parseDouble(sep[5]);
        enemy1.xE = Double.parseDouble(sep[7]);
        enemy1.yE = Double.parseDouble(sep[8]);
        enemy2.xE = Double.parseDouble(sep[9]);
        enemy2.yE = Double.parseDouble(sep[10]);
        enemy3.xE = Double.parseDouble(sep[11]);
        enemy3.yE = Double.parseDouble(sep[12]);
        enemy4.xE = Double.parseDouble(sep[13]);
        enemy4.yE = Double.parseDouble(sep[14]);
        enemy5.xE = Double.parseDouble(sep[15]);
        enemy5.yE = Double.parseDouble(sep[16]);
        enemy6.xE = Double.parseDouble(sep[17]);
        enemy6.yE = Double.parseDouble(sep[18]);
        enemy7.xE = Double.parseDouble(sep[19]);
        enemy7.yE = Double.parseDouble(sep[20]);
        enemy8.xE = Double.parseDouble(sep[21]);
        enemy8.yE = Double.parseDouble(sep[22]);
        enemy9.xE = Double.parseDouble(sep[23]);
        enemy9.yE = Double.parseDouble(sep[24]);
        enemy10.xE = Double.parseDouble(sep[25]);
        enemy10.yE = Double.parseDouble(sep[26]);
        enemy11.xE = Double.parseDouble(sep[27]);
        enemy11.yE = Double.parseDouble(sep[28]);
        enemy12.xE = Double.parseDouble(sep[29]);
        enemy12.yE = Double.parseDouble(sep[30]);
        enemy13.xE = Double.parseDouble(sep[31]);
        enemy13.yE = Double.parseDouble(sep[32]);
        enemy14.xE = Double.parseDouble(sep[33]);
        enemy14.yE = Double.parseDouble(sep[34]);
        enemy15.xE = Double.parseDouble(sep[35]);
        enemy15.yE = Double.parseDouble(sep[36]);
        numback = Integer.parseInt(sep[37]);
        enemy1.enemy = new ImageIcon(sep[38]);
        enemy2.enemy = new ImageIcon(sep[39]);
        enemy3.enemy = new ImageIcon(sep[40]);
        enemy4.enemy = new ImageIcon(sep[41]);
        enemy5.enemy = new ImageIcon(sep[42]);
        enemy6.enemy = new ImageIcon(sep[43]);
        enemy7.enemy = new ImageIcon(sep[44]);
        enemy8.enemy = new ImageIcon(sep[45]);
        enemy9.enemy = new ImageIcon(sep[46]);
        enemy10.enemy = new ImageIcon(sep[47]);
        enemy11.enemy = new ImageIcon(sep[48]);
        enemy12.enemy = new ImageIcon(sep[49]);
        enemy13.enemy = new ImageIcon(sep[50]);
        enemy14.enemy = new ImageIcon(sep[51]);
        enemy15.enemy = new ImageIcon(sep[52]);
        box1 = new ImageIcon(sep[53]);
        back = backgrounds.get(numback);
        icon = new ImageIcon(back);
        image.setIcon(icon);
        this.add(image);
        ///
       //bara khoodeshe
         BufferedImage bufferedImage12 = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g12 = bufferedImage12.createGraphics();
        if (sX2 - x2 > 0) {
            g12.rotate(Math.atan((sY2 - y2) / (sX2 - x2)), 30, 30);
        }
        if (sX2 - x2 < 0) {
            g12.rotate(Math.atan((sY2 - y2) / (sX2 - x2)) + Math.toRadians(180), 30, 30);
        }
        g12.drawImage(bb3.getImage(), 0, 0, 60, 60, null);
        arg0.drawImage(bufferedImage12, (int) x2, (int) y2, null);
         BufferedImage bufferedImage22 = new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g22 = bufferedImage22.createGraphics();
        g22.drawImage(c.getImage(), 0, 0, 20, 20, null);
        arg0.drawImage(bufferedImage22, (int) xt2, (int) yt2, null);
        ///
        BufferedImage bufferedImage1 = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g1 = bufferedImage1.createGraphics();
        if (sX - x > 0) {
            g1.rotate(Math.atan((sY - y) / (sX - x)), 30, 30);
        }
        if (sX - x < 0) {
            g1.rotate(Math.atan((sY - y) / (sX - x)) + Math.toRadians(180), 30, 30);
        }
        g1.drawImage(bb3.getImage(), 0, 0, 60, 60, null);
        arg0.drawImage(bufferedImage1, (int) x, (int) y, null);
        BufferedImage bufferedImage2 = new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage2.createGraphics();
        g2.drawImage(c.getImage(), 0, 0, 20, 20, null);
        arg0.drawImage(bufferedImage2, (int) xt, (int) yt, null);
        //age back 1 dashtim
        if (numback == 1) {
             arg0.drawImage(box1.getImage(), 500, 300, null);
            arg0.drawImage(enemy1.enemy.getImage(), (int) enemy1.xE, (int) enemy1.yE, null);
            arg0.drawImage(enemy2.enemy.getImage(), (int) enemy2.xE, (int) enemy2.yE, null);
        }
        //age back 2 dashtim
        if (numback == 2) {
            arg0.drawImage(enemy3.enemy.getImage(), (int) enemy3.xE, (int) enemy3.yE, null);
            arg0.drawImage(enemy4.enemy.getImage(), (int) enemy4.xE, (int) enemy4.yE, null);
            arg0.drawImage(enemy5.enemy.getImage(), (int) enemy5.xE, (int) enemy5.yE, null);
        }
        if (numback == 3) {
            arg0.drawImage(enemy6.enemy.getImage(), (int) enemy6.xE, (int) enemy6.yE, null);
            arg0.drawImage(enemy7.enemy.getImage(), (int) enemy7.xE, (int) enemy7.yE, null);
            arg0.drawImage(enemy8.enemy.getImage(), (int) enemy8.xE, (int) enemy8.yE, null);
            arg0.drawImage(enemy9.enemy.getImage(), (int) enemy9.xE, (int) enemy9.yE, null);
            arg0.drawImage(enemy10.enemy.getImage(), (int) enemy10.xE, (int) enemy10.yE, null);
        }
        if (numback == 4) {
            arg0.drawImage(enemy11.enemy.getImage(), (int) enemy11.xE, (int) enemy11.yE, null);
            arg0.drawImage(enemy12.enemy.getImage(), (int) enemy12.xE, (int) enemy12.yE, null);
            arg0.drawImage(enemy13.enemy.getImage(), (int) enemy13.xE, (int) enemy13.yE, null);
            arg0.drawImage(enemy14.enemy.getImage(), (int) enemy14.xE, (int) enemy14.yE, null);
            arg0.drawImage(enemy15.enemy.getImage(), (int) enemy15.xE, (int) enemy15.yE, null);
        }

    }

    @Override
    public void run() {
        int i = 0;
        while (i != -1) {
            byte[] b = new byte[400];
            try {
                i = input.read(b);
                if (i != -1) {
                    a1 = new String(b);
                    sep = a1.split(",");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (shelik2 == 1) {
                
                if (x2 - sx2 >= 10 && y2 - sy2 >= 0) {
                    xt2 = xt2 - 5;
                    yt2 = (a2 * xt2) + b2;
                    if (xt2 < 0 && yt < 0) {
                        shelik2 = 0;
                    }
                }
                if (x2 - sx2 <= -10 && y2 - sy2 >= 0) {
                    xt2 = xt2 + 5;
                    yt2 = (a2 * xt2) + b2;
                    if (xt2 > 1000 && yt2 < 0) {
                        shelik2 = 0;
                    }
                }
                if (x2 - sx2 >= 10 && y2 - sy2 < 0) {
                    xt2 = xt2 - 5;
                    yt2 = (a2 * xt2) + b2;
                    if (xt2 < 0 && yt2 > 750) {
                        shelik2 = 0;
                    }
                }
                if (x2 - sx2 <= -10 && y2 - sy2 < 0) {
                    xt2 = xt2 + 5;
                    yt2 = (a2 * xt2) + b2;
                    if (xt2 > 1000 && yt2 > 750) {
                        shelik2 = 0;
                    }
                }
                if (x2 - sx2 > -10 && x2 - sx2 < 10) {
                    if (y2 - sy2 > 0) {
                        a2=1;
                        yt2 = yt2 +5;
                    }
                    if (y2 - sy2 < 0) {
                        a2=1;
                        yt2 = yt2 - 5;
                    }
                
                    if (yt2 > 1000 || yt2 < 0) {
                        shelik2 = 0;
                    }
                }
            }
            try{
                            String s1 = Double.toString(xt2);
                            String s2 = Double.toString(yt2);
                            String s3 = Double.toString(x2);
                            String s4 = Double.toString(y2);
                            String s5 = Double.toString(sX2);
                            String s6 = Double.toString(sY2);
                            String s = s1+","+s2+","+s3+","+s4+","+s5+","+s6+",";
                            output.write((s).getBytes());
                        } catch (IOException ex){
                            Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
                        }   
            repaint();
        }
         
       
      //   repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (x2 < 940 && numback == 1) {
                x2 += 5;
            }
            if (x2 < 600 && numback == 2) {
                x2 += 5;
            }
             if (numback == 3 || numback==4) {
                x2 += 5;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (x2 > 430 && numback == 1) {
                x2 -= 5;
            }
            if (x2 > 430 && numback == 2) {
                x2 -= 5;
            }
             if (numback == 3 || numback==4) {
                x2 -= 5;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (y2 > 55 && numback == 1) {
                y2 -= 5;
            }
            if (y2 > 30 && numback == 2) {
                y2 -= 5;
            }
            if (numback == 3 || numback==4) {
                y2 -= 5;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (y2 < 700 && numback == 1) {
                y2 += 5;
            }
            if (y2 < 680 && numback == 2) {
                y2 += 5;
            }
           if (numback == 3 || numback==4) {
                y2 += 5;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
          Point point = e.getPoint();
        sX2 = point.x;
        sY2 = point.y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();
        xt2 = x2;
        yt2 = y2;
        sX2 = point.x;
        sY2 = point.y;
        sx2 = sX2;
        sy2 = sY2;
     //   makhraj = x - sx;
        a2 = (y2 - sy2) / (x2 - sx2);
        b2 = y2 - a2 * x2;
        shelik2 = 1;
//   
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
