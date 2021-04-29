package sample;


import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Semaphore;

public class Controller implements Initializable {
     @FXML
    AnchorPane pane;
    @FXML
    Label l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    @FXML
    Polyline p156,p256,p356;
    @FXML
    Line p11,p12,p13,p14,p15,p16,p17,p18,p19,p21,p22,p23,p24,p25,p26,p27,p28,p29,p31,p32,p33,p34,p35,p36,p37,p38,p39;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Place [] places = new Place[13];

        Semaphore s = new Semaphore(1);


        places[0] = new Place(1,
                "10 patients 1",
                10,
                new int[]{},
                new int[]{1}
                ,1);

        places[1] = new Place(2,
                "10 patients 2",
                10,
                new int[]{},
                new int[]{2}
                ,2);

        places[2] = new Place(3,
                "10 patients 3",
                10,
                new int[]{},
                new int[]{3}
                ,3);


        places[3] = new Place(4,
                "Attente patient 1",
                0,
                new int[]{1},
                new int[]{4},
                1);

        places[4] = new Place(5,
                "Attente patient 2",
                0,
                new int[]{2},
                new int[]{5},
                2);

        places[5] = new Place(6,
                "Attente Patient 3",
                0,
                new int[]{3},
                new int[]{6}
                ,3);

        places[6] = new Place(7,
                "Medecin 1 Disponible",
                1,
                new int[]{7},
                new int[]{4},
                1);

        places[7] = new Place(8,
                "Medecin 2 Disponible",
                1,
                new int[]{8},
                new int[]{5},
                2);

        places[8] = new Place(9,
                "Medecin 3 Disponible",
                1,
                new int[]{9},
                new int[]{6},
                3);

        places[9] = new Place(10,
                "Patient 1 en examen",
                0,
                new int[]{4},
                new int[]{7}
                ,1);

        places[10] = new Place(11,
                "Patient 2 en examen",
                0,
                new int[]{5},
                new int[]{8},
                2);

        places[11] = new Place(12,
                "Patient 3 en examen",
                0,
                new int[]{6},
                new int[]{9},
                3);

        places[12] = new Place(13,
                "Salle examen Disponible",
                2,
                new int[]{7,8,9},
                new int[]{4,5,6}
                ,0);


        for(int i= 0;i<places.length;i++)
        places[i].activate(1);
        for(int i= 0;i<places.length;i++)
        places[i].activate(2);
        for(int i= 0;i<places.length;i++)
        places[i].activate(3);

            //medcin 1
            new Thread() {
                @Override
                public void run() {
                    int zero = 2;
                    while (places[0].jetons >= 0) {

                        if (places[0].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(1,p11);

                                }
                            });
                            places[3].jetons++;
                            addValue(l3, 1);
                            places[0].jetons--;
                            addValue(l0, -1);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(1);
                        System.out.println("----------------");


                        if (places[3].jetons > 0 && places[12].jetons > 0 && places[6].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(2,p13);
                                    travelFromAtoB(1,p17);
                                    travelFromAtoB(1,p18);


                                }
                            });


                            places[9].jetons++;
                            addValue(l9, 1);

                            places[3].jetons--;
                            addValue(l3, -1);

                            try {
                                s.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            places[12].jetons--;
                            addValue(l12, -1);

                            s.release();
                            places[6].jetons--;
                            addValue(l6, -1);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(1);
                        System.out.println("----------------");

                        if (places[9].jetons > 0) {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        travelFromAtoB(2,p156);
                                        travelFromAtoB(1,p19);
                                    }
                                });
                            try {
                                s.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            places[12].jetons++;
                            addValue(l12, 1);

                            s.release();
                            places[6].jetons++;
                            addValue(l6, 1);

                            places[9].jetons--;
                            addValue(l9, -1);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(1);
                        System.out.println("----------------");
                        if(zero==0)break;
                        if(places[2].jetons ==0)zero--;


                    }
                }
            }.start();
            //medcin 2




            new Thread() {
                @Override
                public void run() {
                    while (places[1].jetons > 0) {

                        if (places[1].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(1,p21);

                                }
                            });
                            places[4].jetons++;
                            addValue(l4, 1);

                            places[1].jetons--;
                            addValue(l1, -1);

                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(2);
                        System.out.println("----------------");


                        if (places[4].jetons > 0 && places[12].jetons > 0 && places[7].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(2,p23);
                                    travelFromAtoB(1,p27);
                                    travelFromAtoB(1,p28);


                                }
                            });
                            places[10].jetons++;
                            addValue(l10, 1);

                            places[4].jetons--;
                            addValue(l4, -1);

                            try {
                                s.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            places[12].jetons--;
                            addValue(l12, -1);

                            s.release();
                            places[7].jetons--;
                            addValue(l7, -1);

                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(2);
                        System.out.println("----------------");

                        if (places[10].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(2,p256);
                                    travelFromAtoB(1,p29);
                                }
                            });
                            try {
                                s.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            places[12].jetons++;
                            addValue(l12, 1);
                            s.release();
                            places[7].jetons++;
                            addValue(l7, 1);
                            places[10].jetons--;
                            addValue(l10, -1);
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(2);
                        System.out.println("----------------");
                    }
                }
            }.start();


            //medcin 3
            new Thread() {
                int zero = 2;

                @Override
                public void run() {
                    while (places[2].jetons >= 0) {
                        if (places[2].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(1,p31);

                                }
                            });
                            places[5].jetons++;
                            addValue(l5, 1);

                            places[2].jetons--;
                            addValue(l2, -1);

                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(3);
                        System.out.println("----------------");


                        if (places[5].jetons > 0 && places[12].jetons > 0 && places[8].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(2,p33);
                                    travelFromAtoB(1,p37);
                                    travelFromAtoB(1,p38);


                                }
                            });
                            places[11].jetons++;
                            addValue(l11, 1);

                            places[5].jetons--;
                            addValue(l5, -1);

                            try {
                                s.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            places[12].jetons--;
                            addValue(l12, -1);

                            s.release();
                            places[8].jetons--;
                            addValue(l8, -1);

                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(3);
                        System.out.println("----------------");

                        if (places[11].jetons > 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    travelFromAtoB(2,p356);
                                    travelFromAtoB(1,p39);
                                }
                            });
                            try {
                                s.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            places[12].jetons++;
                            addValue(l12, 1);

                            s.release();
                            places[8].jetons++;
                            addValue(l8, 1);
                            places[11].jetons--;
                            addValue(l11, -1);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 0; i < places.length; i++)
                            places[i].activate(3);

                        System.out.println("----------------");
                        if(zero==0)break;
                        if(places[2].jetons ==0)zero--;
                    }
                }
            }.start();

        }



    private void addValue(Label lbl, int value) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lbl.setText(String.valueOf(Integer.parseInt(lbl.getText()) + value));
            }
        });
    }
    private void travelFromAtoB(int duration,Line path){
        Circle c = new Circle(5);

        c.setStroke(Color.BLACK);
        c.setFill(Color.BLACK);

        pane.getChildren().add(c);
        PathTransition t = new PathTransition();
        t.setDuration(Duration.seconds(duration));
        t.setNode(c);
        t.setPath(path);
        t.play();
        t.setOnFinished(event -> {
            pane.getChildren().remove(c);
        });
    }
    private void travelFromAtoB(int duration, Polyline path){
        Circle c = new Circle(5);

        c.setStroke(Color.BLACK);
        c.setFill(Color.BLACK);

        pane.getChildren().add(c);
        PathTransition t = new PathTransition();
        t.setDuration(Duration.seconds(duration));
        t.setNode(c);
        t.setPath(path);
        t.play();
        t.setOnFinished(event -> {
            pane.getChildren().remove(c);
        });
    }
}
