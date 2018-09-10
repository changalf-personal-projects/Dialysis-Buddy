package com.example.android.dialysisbuddy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alfredchang on 2018-09-10.
 */

public class Dispensers {

    private static List<Integer> dispensers = new ArrayList<Integer>() {{
        add(R.drawable.med_dispenser_1);
        add(R.drawable.med_dispenser_2);
        add(R.drawable.med_dispenser_1);
        add(R.drawable.med_dispenser_2);
        add(R.drawable.med_dispenser_1);
        add(R.drawable.med_dispenser_2);
    }};

    public static List<Integer> getDispensers() {
        return dispensers;
    }
}
