package com.as.calcy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button black1;
    private Button black2;
    private Button black3;
    private Button black4;
    private Button black5;
    private Button black6;
    private Button black7;
    private Button black8;
    private Button black9;
    private Button black0;
    private Button orange_equal;
    private Button orange_multi;
    private Button orange_divide;
    private Button orange_add;
    private Button orange_sub;
    private Button blue_all_clear;
    private Button black_dot;
    private Button blue_para1;
    private Button blue_para2;
    private TextView first_number;
    private TextView second_number;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '=';
    private final char EXTRA = '@';
    private final char MODULUS = '%';
    private char ACTION;
    private double value1 = Double.NaN;
    private double value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_layout);
        viewSetup();

        black1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "1");
            }
        });

        black2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "2");
            }
        });

        black3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "3");
            }
        });

        black4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "4");
            }
        });

        black5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "5");
            }
        });

        black6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "6");
            }
        });

        black7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "7");
            }
        });

        black8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "8");
            }
        });

        black9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "9");
            }
        });

        black0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                first_number.setText(first_number.getText().toString() + "0");
            }
        });

        black_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                first_number.setText(first_number.getText().toString() + ".");
            }
        });

        blue_para1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_number.getText().length() > 0) {
                    ACTION = MODULUS;
                    operation();
                    if (!ifReallyDecimal()) {
                        second_number.setText(value1 + "%");
                    } else {
                        second_number.setText((int) value1 + "%");
                    }
                    first_number.setText(null);
                } else {
                    second_number.setText("Error");
                }
            }
        });

        orange_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_number.getText().length() > 0) {
                    ACTION = ADDITION;
                    operation();
                    if (!ifReallyDecimal()) {
                        second_number.setText(value1 + "+");
                    } else {
                        second_number.setText((int) value1 + "+");
                    }
                    first_number.setText(null);
                } else {
                    second_number.setText("Error");
                }
            }
        });

        orange_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_number.getText().length() > 0) {
                    ACTION = SUBTRACTION;
                    operation();
                    if (first_number.getText().length() > 0)
                        if (!ifReallyDecimal()) {
                            second_number.setText(value1 + "-");
                        } else {
                            second_number.setText((int) value1 + "-");
                        }
                    first_number.setText(null);
                } else {
                    second_number.setText("Error");
                }
            }
        });

        orange_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_number.getText().length() > 0) {
                    ACTION = MULTIPLICATION;
                    operation();
                    if (!ifReallyDecimal()) {
                        second_number.setText(value1 + "×");
                    } else {
                        second_number.setText((int) value1 + "×");
                    }
                    first_number.setText(null);
                } else {
                    second_number.setText("Error");
                }
            }
        });

        orange_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_number.getText().length() > 0) {
                    ACTION = DIVISION;
                    operation();
                    if (ifReallyDecimal()) {
                        second_number.setText((int) value1 + "/");
                    } else {
                        second_number.setText(value1 + "/");
                    }
                    first_number.setText(null);
                } else {
                    second_number.setText("Error");
                }
            }
        });

        blue_para2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!second_number.getText().toString().isEmpty() || !first_number.getText().toString().isEmpty()) {
                    value1 = Double.parseDouble(first_number.getText().toString());
                    ACTION = EXTRA;
                    second_number.setText("-" + first_number.getText().toString());
                    first_number.setText("");
                } else {
                    second_number.setText("Error");
                }
            }
        });

        orange_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_number.getText().length() > 0) {
                    operation();
                    ACTION = EQUAL;
                    if (!ifReallyDecimal()) {
                        second_number.setText(String.valueOf(value1));
                    } else {
                        second_number.setText(String.valueOf((int) value1));
                    }
                    first_number.setText(null);
                } else {
                    second_number.setText("Error");
                }
            }
        });

        blue_all_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_number.getText().length() > 0) {
                    CharSequence name = first_number.getText().toString();
                    first_number.setText(name.subSequence(0, name.length() - 1));
                } else {
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    first_number.setText("");
                    second_number.setText("");
                }
            }
        });

        // Empty text views on long click.
        blue_all_clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                value1 = Double.NaN;
                value2 = Double.NaN;
                first_number.setText("");
                second_number.setText("");
                return true;
            }
        });
    }

    private void viewSetup() {
        black1 = findViewById(R.id.button1);
        black2 = findViewById(R.id.button2);
        black3 = findViewById(R.id.button3);
        black4 = findViewById(R.id.button4);
        black5 = findViewById(R.id.button5);
        black6 = findViewById(R.id.button6);
        black7 = findViewById(R.id.button7);
        black8 = findViewById(R.id.button8);
        black9 = findViewById(R.id.button9);
        black0 = findViewById(R.id.button0);
        orange_equal = findViewById(R.id.button_equal);
        orange_multi = findViewById(R.id.button_multi);
        orange_divide = findViewById(R.id.button_divide);
        orange_add = findViewById(R.id.button_add);
        orange_sub = findViewById(R.id.button_sub);
        blue_all_clear = findViewById(R.id.button_clear);
        black_dot = findViewById(R.id.button_dot);
        blue_para1 = findViewById(R.id.button_para1);
        blue_para2 = findViewById(R.id.button_para2);
        first_number = findViewById(R.id.input);
        second_number = findViewById(R.id.output);
    }

    private void operation() {
        if (!Double.isNaN(value1)) {
            if (second_number.getText().toString().charAt(0) == '-') {
                value1 = (-1) * value1;
            }
            value2 = Double.parseDouble(first_number.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    value1 = value1 + value2;
                    break;
                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;
                case MULTIPLICATION:
                    value1 = value1 * value2;
                    break;
                case DIVISION:
                    value1 = value1 / value2;
                    break;
                case EXTRA:
                    value1 = (-1) * value1;
                    break;
                case MODULUS:
                    value1 = value1 % value2;
                    break;
                case EQUAL:
                    break;
            }
        } else {
            value1 = Double.parseDouble(first_number.getText().toString());
        }
    }

    // Remove error message that is already written there.
    private void ifErrorOnOutput() {
        if (second_number.getText().toString().equals("Error")) {
            second_number.setText("");
        }
    }

    // Whether value if a double or not
    private boolean ifReallyDecimal() {
        return value1 == (int) value1;
    }

    private void noOperation() {
        String inputExpression = second_number.getText().toString();
        if (!inputExpression.isEmpty() && !inputExpression.equals("Error")) {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "");
                second_number.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "");
                second_number.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "");
                second_number.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "");
                second_number.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "");
                second_number.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
        }
    }

    // Make text small if too many digits.
    private void exceedLength() {
        if (first_number.getText().toString().length() > 10) {
            first_number.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }
}