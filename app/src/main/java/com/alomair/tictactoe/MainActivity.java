package com.alomair.tictactoe;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    private TextView result, txt_player_1, txt_player_2;

    private boolean step1 = false;
    private boolean step2 = false;
    private boolean step3 = false;
    private boolean step4 = false;
    private boolean step5 = false;
    private boolean step6 = false;
    private boolean step7 = false;
    private boolean step8 = false;
    private boolean step9 = false;

    private boolean step1P1 = false;
    private boolean step2P1 = false;
    private boolean step3P1 = false;
    private boolean step4P1 = false;
    private boolean step5P1 = false;
    private boolean step6P1 = false;
    private boolean step7P1 = false;
    private boolean step8P1 = false;
    private boolean step9P1 = false;

    private boolean step1P2 = false;
    private boolean step2P2 = false;
    private boolean step3P2 = false;
    private boolean step4P2 = false;
    private boolean step5P2 = false;
    private boolean step6P2 = false;
    private boolean step7P2 = false;
    private boolean step8P2 = false;
    private boolean step9P2 = false;


    private boolean isPlayer1 = true;
    private boolean isGameRuining = false;

    private int numberOfWinsForPlayer1;
    private int numberOfWinsForPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txt_player_1 = findViewById(R.id.txt_player_1);
        txt_player_2 = findViewById(R.id.txt_player_2);
        block1 = findViewById(R.id.bt_block1);
        block2 = findViewById(R.id.bt_block2);
        block3 = findViewById(R.id.bt_block3);
        block4 = findViewById(R.id.bt_block4);
        block5 = findViewById(R.id.bt_block5);
        block6 = findViewById(R.id.bt_block6);
        block7 = findViewById(R.id.bt_block7);
        block8 = findViewById(R.id.bt_block8);
        block9 = findViewById(R.id.bt_block9);
        result = findViewById(R.id.tv_show_result);
        restart = findViewById(R.id.bt_restart_game);


        block1.setOnClickListener(this);
        block2.setOnClickListener(this);
        block3.setOnClickListener(this);
        block4.setOnClickListener(this);
        block5.setOnClickListener(this);
        block6.setOnClickListener(this);
        block7.setOnClickListener(this);
        block8.setOnClickListener(this);
        block9.setOnClickListener(this);

        resetTheGame();
        clearData();

        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGameRuining) restartNewGame();
                else
                    startNewGame();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_reset:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.app_name)
                        .setMessage(R.string.ask_reset_game)
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                result.setText("");
                                isGameRuining = true;
                                resetTheGame();
                                clearData();
                            }
                        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_block1:
                if (isButtonChecked(block1)) {
                    checkButton(block1);
                    setSteps(1);
                }
                break;
            case R.id.bt_block2:
                if (isButtonChecked(block2)) {
                    checkButton(block2);
                    setSteps(2);
                }
                break;
            case R.id.bt_block3:
                if (isButtonChecked(block3)) {
                    checkButton(block3);
                    setSteps(3);
                }
                break;
            case R.id.bt_block4:
                if (isButtonChecked(block4)) {
                    checkButton(block4);
                    setSteps(4);
                }
                break;
            case R.id.bt_block5:
                if (isButtonChecked(block5)) {
                    checkButton(block5);
                    setSteps(5);
                }
                break;
            case R.id.bt_block6:
                if (isButtonChecked(block6)) {
                    checkButton(block6);
                    setSteps(6);
                }
                break;
            case R.id.bt_block7:
                if (isButtonChecked(block7)) {
                    checkButton(block7);
                    setSteps(7);
                }
                break;
            case R.id.bt_block8:
                if (isButtonChecked(block8)) {
                    checkButton(block8);
                    setSteps(8);
                }
                break;
            case R.id.bt_block9:
                if (isButtonChecked(block9)) {
                    checkButton(block9);
                    setSteps(9);
                }
                break;
        }
    }

    private boolean isButtonChecked(Button block) {
        return block.getText().toString().isEmpty();
    }


    private void checkButton(Button block) {
        if (isGameRuining) {
            if (isPlayer1) {
                block.setText("0");
            } else {
                block.setText("X");
            }
        }
    }

    private void setStepColor() {
        if (isGameRuining) {
            if (isPlayer1) {
                txt_player_1.setBackgroundColor(Color.GREEN);
                txt_player_2.setBackgroundColor(Color.RED);
            } else {
                txt_player_1.setBackgroundColor(Color.RED);
                txt_player_2.setBackgroundColor(Color.GREEN);
            }
        }
    }

    private void setSteps(int step) {
        switch (step) {
            case 1:
                if (!step1)
                    step1 = true;
                if (isPlayer1) step1P1 = true;
                else step1P2 = true;
                break;
            case 2:
                if (!step2)
                    step2 = true;
                if (isPlayer1) step2P1 = true;
                else step2P2 = true;
                break;
            case 3:
                if (!step3)
                    step3 = true;
                if (isPlayer1) step3P1 = true;
                else step3P2 = true;
                break;
            case 4:
                if (!step4)
                    step4 = true;
                if (isPlayer1) step4P1 = true;
                else step4P2 = true;
                break;
            case 5:
                if (!step5)
                    step5 = true;
                if (isPlayer1) step5P1 = true;
                else step5P2 = true;
                break;
            case 6:
                if (!step6)
                    step6 = true;
                if (isPlayer1) step6P1 = true;
                else step6P2 = true;
                break;
            case 7:
                if (!step7)
                    step7 = true;
                if (isPlayer1) step7P1 = true;
                else step7P2 = true;
                break;
            case 8:
                if (!step8)
                    step8 = true;
                if (isPlayer1) step8P1 = true;
                else step8P2 = true;
                break;
            case 9:
                if (!step9)
                    step9 = true;
                if (isPlayer1) step9P1 = true;
                else step9P2 = true;
                break;
        }
        checkWinner();
    }

    private void checkWinner() {
        if (isPlayer1) {
            if (checkBlockToPlayer1())
                showWinner1();
            else if (checkAllBlock()) {
                // next step is for Player2
                isPlayer1 = false;
                setStepColor();
            }
        } else {
            if (checkBlockToPlayer2())
                showWinner2();
            else if (checkAllBlock()) {
                // next step is for Player1
                isPlayer1 = true;
                setStepColor();
            }
        }
    }

    private boolean checkBlockToPlayer1() {
        if (step1P1 && step2P1 && step3P1) {
            return true;
        } else if (step4P1 && step5P1 && step6P1) {
            return true;
        } else if (step7P1 && step8P1 && step9P1) {
            return true;
        } else if (step1P1 && step4P1 && step7P1) {
            return true;
        } else if (step2P1 && step5P1 && step8P1) {
            return true;
        } else if (step3P1 && step6P1 && step9P1) {
            return true;
        } else if (step1P1 && step5P1 && step9P1) {
            return true;
        } else if (step3P1 && step5P1 && step7P1) {
            return true;
        } else return false;
    }

    private boolean checkBlockToPlayer2() {
        if (step1P2 && step2P2 && step3P2) {
            return true;
        } else if (step4P2 && step5P2 && step6P2) {
            return true;
        } else if (step7P2 && step8P2 && step9P2) {
            return true;
        } else if (step1P2 && step4P2 && step7P2) {
            return true;
        } else if (step2P2 && step5P2 && step8P2) {
            return true;
        } else if (step3P2 && step6P2 && step9P2) {
            return true;
        } else if (step1P2 && step5P2 && step9P2) {
            return true;
        } else if (step3P2 && step5P2 && step7P2) {
            return true;
        } else return false;

    }

    private boolean checkAllBlock() {
        if (step1 && step2 && step3 & step4 && step5 && step6 & step7 && step8 && step9) {
            result.setText(R.string.its_a_tie);
            isGameRuining = false;
            clearData();
            return false;
        } else return true;
    }

    private void showWinner1() {
        ++numberOfWinsForPlayer1;
        txt_player_1.setText(getString(R.string.player_1_o, numberOfWinsForPlayer1));
        result.setText(R.string.player1_is_winner);
        isGameRuining = false;
        clearData();
    }

    private void showWinner2() {
        ++numberOfWinsForPlayer2;
        txt_player_2.setText(getString(R.string.player_1_o, numberOfWinsForPlayer2));
        result.setText(R.string.player2_is_winner);
        isGameRuining = false;
        clearData();
    }

    private void restartNewGame() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.ask_restart_game)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startNewGame();
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    private void startNewGame() {
        result.setText("");
        isGameRuining = true;
        clearData();
        setStepColor();
    }

    private void resetTheGame() {
        numberOfWinsForPlayer1 = 0;
        txt_player_1.setText(getString(R.string.player_1_o, numberOfWinsForPlayer1));
        numberOfWinsForPlayer2 = 0;
        txt_player_2.setText(getString(R.string.player_1_o, numberOfWinsForPlayer2));

    }

    private void clearData() {
        isPlayer1 = true;

        block1.setText("");
        block2.setText("");
        block3.setText("");
        block4.setText("");
        block5.setText("");
        block6.setText("");
        block7.setText("");
        block8.setText("");
        block9.setText("");

        step1 = false;
        step2 = false;
        step3 = false;
        step4 = false;
        step5 = false;
        step6 = false;
        step7 = false;
        step8 = false;
        step9 = false;

        step1P1 = false;
        step2P1 = false;
        step3P1 = false;
        step4P1 = false;
        step5P1 = false;
        step6P1 = false;
        step7P1 = false;
        step8P1 = false;
        step9P1 = false;

        step1P2 = false;
        step2P2 = false;
        step3P2 = false;
        step4P2 = false;
        step5P2 = false;
        step6P2 = false;
        step7P2 = false;
        step8P2 = false;
        step9P2 = false;

        txt_player_1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        txt_player_2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        restart.setText(isGameRuining ? R.string.restart_button_text_in_middle_of_game : R.string.restart_button_text_initially);
    }

}
