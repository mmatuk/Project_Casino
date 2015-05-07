package main;


import Games.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt
 */
public class MainPanel extends javax.swing.JPanel
{

    private final String RAISE = "RAISE";
    private final String LOWER = "LOWER";
    private final String BET_AMOUNT = "Bet Amount";
    
    private final int RASISE_INT = 0; // for the combo box 
    private final int LOWER_INT = 1; // for the combo box
    
    private final double BET_ONE = 1.00;
    private final double BET_FIVE = 5.00;
    private final double BET_TEN = 10.00;    
    private final double BET_TWENTY_FIVE = 25.00;
    private final double BET_FIFTY = 50.00;
    private final double BET_ONE_HUNDRED = 100.00;
    
    private String userName = "Matt Matuk";
    
    private static double bankAccount;
    private static double betAmount;
        
    private static Game[] games;
    
    
    /**
     * Creates new form MainPanel
     */
    public MainPanel()
    {
        initComponents();
        setComponetValues();
        initVariables();

        createGames();
        displayGameBoards();
        updateCurrentBet();
        updateBankBal();
        
        displayResultsPanel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanelUserInfo = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblBankBal = new javax.swing.JLabel();
        lblBal = new javax.swing.JLabel();
        btnAddMoney = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanelBetting = new javax.swing.JPanel();
        lblAmountBet = new javax.swing.JLabel();
        comboRasieLow = new javax.swing.JComboBox();
        lblCurrentBet = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblSetBet = new javax.swing.JLabel();
        btnBet10 = new javax.swing.JButton();
        btnBet25 = new javax.swing.JButton();
        btnBet1 = new javax.swing.JButton();
        btnBet5 = new javax.swing.JButton();
        btnBet100 = new javax.swing.JButton();
        btnBet50 = new javax.swing.JButton();
        btnAddBetAmount = new javax.swing.JButton();
        NumberFormat bettingFormat = NumberFormat.getIntegerInstance();
        jFormattedTextFieldBetAmount = new javax.swing.JFormattedTextField(bettingFormat);
        btnBet = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jTabbedPaneGames = new javax.swing.JTabbedPane();
        jPanelResults = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1400, 829));

        jPanelUserInfo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelUserInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblUserName.setText(userName);

        lblBankBal.setText("Current Balance:");

        lblBal.setText("1000,000");

        btnAddMoney.setText("Add");
        btnAddMoney.setToolTipText("");
        btnAddMoney.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddMoneyActionPerformed(evt);
            }
        });

        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUserInfoLayout = new javax.swing.GroupLayout(jPanelUserInfo);
        jPanelUserInfo.setLayout(jPanelUserInfoLayout);
        jPanelUserInfoLayout.setHorizontalGroup(
            jPanelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUserInfoLayout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                    .addGroup(jPanelUserInfoLayout.createSequentialGroup()
                        .addComponent(lblBankBal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelUserInfoLayout.setVerticalGroup(
            jPanelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBankBal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelUserInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelBetting.setBackground(new java.awt.Color(204, 204, 204));
        jPanelBetting.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblAmountBet.setText("Amount Betting:");

        comboRasieLow.setModel(new javax.swing.DefaultComboBoxModel());
        comboRasieLow.setPreferredSize(new java.awt.Dimension(64, 25));

        lblCurrentBet.setText("1000,000");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblSetBet.setText("Enter Amount:");

        btnBet10.setText("$10");
        btnBet10.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBet10ActionPerformed(evt);
            }
        });

        btnBet25.setText("$25");
        btnBet25.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBet25ActionPerformed(evt);
            }
        });

        btnBet1.setText("$1");
        btnBet1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBet1ActionPerformed(evt);
            }
        });

        btnBet5.setText("$5");
        btnBet5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBet5ActionPerformed(evt);
            }
        });

        btnBet100.setText("$100");
        btnBet100.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBet100ActionPerformed(evt);
            }
        });

        btnBet50.setText("$50");
        btnBet50.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBet50ActionPerformed(evt);
            }
        });

        btnAddBetAmount.setText("Set");
        btnAddBetAmount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddBetAmountActionPerformed(evt);
            }
        });

        jFormattedTextFieldBetAmount.setToolTipText("");
        jFormattedTextFieldBetAmount.setValue(new Integer(500));
        jFormattedTextFieldBetAmount.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jFormattedTextFieldBetAmountMouseClicked(evt);
            }
        });

        btnBet.setText("BET");
        btnBet.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBetActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanelBettingLayout = new javax.swing.GroupLayout(jPanelBetting);
        jPanelBetting.setLayout(jPanelBettingLayout);
        jPanelBettingLayout.setHorizontalGroup(
            jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBettingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBettingLayout.createSequentialGroup()
                        .addComponent(lblAmountBet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCurrentBet, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addComponent(comboRasieLow, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelBettingLayout.createSequentialGroup()
                        .addComponent(lblSetBet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldBetAmount))
                    .addGroup(jPanelBettingLayout.createSequentialGroup()
                        .addComponent(btnBet1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBet5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBettingLayout.createSequentialGroup()
                        .addComponent(btnBet10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBet25, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBet50, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBet100, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddBetAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBet)
                .addContainerGap())
        );
        jPanelBettingLayout.setVerticalGroup(
            jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBettingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBettingLayout.createSequentialGroup()
                        .addGroup(jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSetBet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCurrentBet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAmountBet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddBetAmount)
                                .addComponent(jFormattedTextFieldBetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboRasieLow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBet1)
                                .addComponent(btnBet5)
                                .addComponent(btnBet10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBet25)
                                .addComponent(btnBet100)
                                .addComponent(btnBet50))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneGames.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jTabbedPaneGamesStateChanged(evt);
            }
        });

        jPanelResults.setBackground(new java.awt.Color(204, 204, 204));
        jPanelResults.setPreferredSize(new java.awt.Dimension(1272, 70));
        jPanelResults.setLayout(new javax.swing.BoxLayout(jPanelResults, javax.swing.BoxLayout.LINE_AXIS));

        btnPlay.setText("PLAY");
        btnPlay.setPreferredSize(new java.awt.Dimension(70, 70));
        btnPlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneGames)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelBetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneGames, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setComponetValues()
    {
        comboRasieLow.addItem(RAISE);
        comboRasieLow.addItem(LOWER);
    }

    /**
     * Creates each game for the casino and adds the game to the games array. 
     * The size of the array will be determined by how many games are playable 
     * in the game.
     * 
     * @return returns a Game[] that was created
     */
    private Game[] createGames()
    {
    	// Add new games to this array
    	Game[] temp = 
    		{
    			new Roulette("Roulette")
    		};
    	
    	games = temp;
    	
    	return games;
    }
    
    /**
     * Sets all game variables to null or 0.
     */
    private void initVariables()
    {
    	games = null;
    	bankAccount = 0;
    	betAmount = 0;
    }
    
    /**
     * Sets up all the game boards by using the games array to get each created 
     * panel and adding that panel to the JTabbedPaneGames panel.
     */
    private void displayGameBoards()
    {
        for (Game game : games)
        {
            jTabbedPaneGames.add(game.getGameName(), game.getGamePanel());
        }
    }
    
    /**
     * Displays the results panel for each game by adding the panel to the
     * jPanelResults panel. Removes the panel if one already is present.
     */
    private void displayResultsPanel()
    {
        // if no panel is present.
        if (jPanelResults.getComponentCount() == 0)
        {
            jPanelResults.add(games[
                    jTabbedPaneGames.getSelectedIndex()].getGameResultsPanel());
        }
        else
        {
            jPanelResults.removeAll();
            jPanelResults.add(games[
                    jTabbedPaneGames.getSelectedIndex()].getGameResultsPanel());
        }
    }
    /**
     * Displays the current users bet using lblCurrentBet
     * 
     */
    public static void updateCurrentBet()
    {
        DecimalFormat currency = new DecimalFormat("$###,###.##");

        if (betAmount >= 0)
        {
            lblCurrentBet.setText(
                    currency.format(betAmount));
        }
        else
        {
            betAmount = 0;
            lblCurrentBet.setText(
                    currency.format(betAmount));
        }
   }
    
    /**
     * Displays the users current bank balance
     */
    private void updateBankBal()
    {
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        lblBal.setText(currency.format(bankAccount));
    }
    
    /**
     * Displays the bank amount after increasing or decreasing the amount 
     * by the double that is passed.
     * 
     * @param amount Amount to add to the bank account balance.
     */
    private void updateBankBal(double amount)
    {
        bankAccount += amount;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        lblBal.setText(currency.format(bankAccount));
    }
    
    /**
     * determines if the user has any money left. displays a message box if no.
     * 
     * @return true if bankAcount is not equal to 0
     */
    public static boolean doesUserHaveMoney()
    {
        if (bankAccount == 0 || (bankAccount - betAmount < 0))
        {
            JOptionPane.showMessageDialog(jTabbedPaneGames, "You do not have enough money.");
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private void btnAddMoneyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddMoneyActionPerformed
    {//GEN-HEADEREND:event_btnAddMoneyActionPerformed
        Object[] amounts = {"$50","$100","$500","$1,000","$2,000","$5,000","$10,000","$50,000"};
        String increaseAmount = (String) JOptionPane.showInputDialog(
                jTabbedPaneGames, "Please select how much you would like to add", 
                "ADD Money", JOptionPane.QUESTION_MESSAGE, null, amounts, 50);
        
        increaseAmount = increaseAmount.replaceAll("[$,]", "");

        updateBankBal(Double.parseDouble(increaseAmount));
    }//GEN-LAST:event_btnAddMoneyActionPerformed

    private void btnBet1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBet1ActionPerformed
    {//GEN-HEADEREND:event_btnBet1ActionPerformed
        if (comboRasieLow.getSelectedIndex() == RASISE_INT)
        {
            betAmount += BET_ONE;
        }
        else
        {
            betAmount -= BET_ONE;       
        }
        updateCurrentBet();
    }//GEN-LAST:event_btnBet1ActionPerformed

    /**
     * When the play button is pressed, the currently displayed tabs game is 
     * played.
     * 
     * @param evt The play button event.
     */
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPlayActionPerformed
    {//GEN-HEADEREND:event_btnPlayActionPerformed
        double preBetAmount = 
                games[jTabbedPaneGames.getSelectedIndex()].getUserBet();
        String wasGamePlayed = games[jTabbedPaneGames.getSelectedIndex()].playGame();
        
        // if the game was played. null means no game played
        if (wasGamePlayed != null)
        {
            updateBankBal(-preBetAmount);
            updateBankBal(games[jTabbedPaneGames.getSelectedIndex()].getPayout());
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnBet5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBet5ActionPerformed
    {//GEN-HEADEREND:event_btnBet5ActionPerformed
        if (comboRasieLow.getSelectedIndex() == RASISE_INT)
        {
            betAmount += BET_FIVE;
        }
        else
        {
            betAmount -= BET_FIVE;       
        }
        updateCurrentBet();
    }//GEN-LAST:event_btnBet5ActionPerformed

    private void btnBet10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBet10ActionPerformed
    {//GEN-HEADEREND:event_btnBet10ActionPerformed
        if (comboRasieLow.getSelectedIndex() == RASISE_INT)
        {
            betAmount += BET_TEN;
        }
        else
        {
            betAmount -= BET_TEN;       
        }
        updateCurrentBet();
    }//GEN-LAST:event_btnBet10ActionPerformed

    private void btnBet25ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBet25ActionPerformed
    {//GEN-HEADEREND:event_btnBet25ActionPerformed
        if (comboRasieLow.getSelectedIndex() == RASISE_INT)
        {
            betAmount += BET_TWENTY_FIVE;
        }
        else
        {
            betAmount -= BET_TWENTY_FIVE;       
        }
        updateCurrentBet();
    }//GEN-LAST:event_btnBet25ActionPerformed

    private void btnBet50ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBet50ActionPerformed
    {//GEN-HEADEREND:event_btnBet50ActionPerformed
        if (comboRasieLow.getSelectedIndex() == RASISE_INT)
        {
            betAmount += BET_FIFTY;
        }
        else
        {
            betAmount -= BET_FIFTY;       
        }
        updateCurrentBet();
    }//GEN-LAST:event_btnBet50ActionPerformed

    private void btnBet100ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBet100ActionPerformed
    {//GEN-HEADEREND:event_btnBet100ActionPerformed
        if (comboRasieLow.getSelectedIndex() == RASISE_INT)
        {
            betAmount += BET_ONE_HUNDRED;
        }
        else
        {
            betAmount -= BET_ONE_HUNDRED;       
        }
        updateCurrentBet();
    }//GEN-LAST:event_btnBet100ActionPerformed

    private void jFormattedTextFieldBetAmountMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jFormattedTextFieldBetAmountMouseClicked
    {//GEN-HEADEREND:event_jFormattedTextFieldBetAmountMouseClicked
        jFormattedTextFieldBetAmount.setValue(null);
    }//GEN-LAST:event_jFormattedTextFieldBetAmountMouseClicked

    private void btnAddBetAmountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddBetAmountActionPerformed
    {//GEN-HEADEREND:event_btnAddBetAmountActionPerformed
        // if bet entered is not empty
        if (!jFormattedTextFieldBetAmount.getText().equalsIgnoreCase(""))
        {
            String onlyNumbers = 
                    jFormattedTextFieldBetAmount.getText().replaceAll("[,]", "");
            double bet = Double.parseDouble(onlyNumbers);
            
            betAmount = bet;
            updateCurrentBet();
        }
    }//GEN-LAST:event_btnAddBetAmountActionPerformed

    /**
     * Event for when the tabbed panes are pressed so the different results 
     * panels can be displayed.
     * @param evt 
     */
    private void jTabbedPaneGamesStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jTabbedPaneGamesStateChanged
    {//GEN-HEADEREND:event_jTabbedPaneGamesStateChanged
        displayResultsPanel();
    }//GEN-LAST:event_jTabbedPaneGamesStateChanged

    /**
     * Adds the current bet to the game current game.
     * 
     * @param evt 
     */
    private void btnBetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBetActionPerformed
    {//GEN-HEADEREND:event_btnBetActionPerformed

        if (doesUserHaveMoney())
        {
            if (betAmount == 0)
            {
                JOptionPane.showMessageDialog(
                        jTabbedPaneGames, "You are currently trying to bet $0.");
            }
            else
            {
                games[jTabbedPaneGames.getSelectedIndex()].setUserBet(betAmount);
                updateCurrentBet();
            }
        }
    }//GEN-LAST:event_btnBetActionPerformed

    /**
     * Changes the username of the player.
     *
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        String userName = (String) JOptionPane.showInputDialog(jTabbedPaneGames, "Please enter a new name.", "NAME");
        if (userName != null)
        {
            lblUserName.setText(userName);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static double getBetAmount()
    {
        
        return betAmount;
    }

    public static void setBetAmount(double bet)
    {
        betAmount = bet;
    }

    public static JTabbedPane getjTabbedPaneGames()
    {
        return jTabbedPaneGames;
    }
    
    public static Game[] getGames()
    {
        return games;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBetAmount;
    private javax.swing.JButton btnAddMoney;
    private javax.swing.JButton btnBet;
    private javax.swing.JButton btnBet1;
    private javax.swing.JButton btnBet10;
    private javax.swing.JButton btnBet100;
    private javax.swing.JButton btnBet25;
    private javax.swing.JButton btnBet5;
    private javax.swing.JButton btnBet50;
    private javax.swing.JButton btnPlay;
    private javax.swing.JComboBox comboRasieLow;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextFieldBetAmount;
    private javax.swing.JPanel jPanelBetting;
    private javax.swing.JPanel jPanelResults;
    private javax.swing.JPanel jPanelUserInfo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private static javax.swing.JTabbedPane jTabbedPaneGames;
    private javax.swing.JLabel lblAmountBet;
    private javax.swing.JLabel lblBal;
    private javax.swing.JLabel lblBankBal;
    private static javax.swing.JLabel lblCurrentBet;
    private javax.swing.JLabel lblSetBet;
    private javax.swing.JLabel lblUserName;
    // End of variables declaration//GEN-END:variables
}