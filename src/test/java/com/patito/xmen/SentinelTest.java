package com.patito.xmen;

import com.patito.xmen.entity.Sentinel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
public class SentinelTest {

    @Test
    public void todos1(){
        Sentinel sentinel = new Sentinel();
        String t1[]= {
                "XTGCXA",
                "CAGTGC",
                "TTATGT",
                "AGAAXG",
                "CCCCTA",
                "TCACTG"};
        assertThat(sentinel.isMutant(t1)).isEqualTo(false);
    }
  @Test
    public void todos2(){
        Sentinel sentinel = new Sentinel();

        String t2[]= {
                "ATGCGA",
                "CXGTGC",
                "TTATGT",
                "AGAXGG",
                "XCXCTA",
                "TCACTG"};
        assertThat(sentinel.isMutant(t2)).isEqualTo(false);

    }
  @Test
    public void todos3(){
        Sentinel sentinel = new Sentinel();

        String t3[]=
                {"ATGCGA",
                        "CXGTXC",
                        "TTATGT",
                        "AGAAGG",
                        "XCXCAA",
                        "TCACTA"};
        assertThat(sentinel.isMutant(t3)).isEqualTo(false);

    }
  @Test
    public void todos4(){
        Sentinel sentinel = new Sentinel();

        String t4[]= {"ATGCGA",
                "CXGTAC",
                "TTAAGT",
                "AGAXGG",
                "XCXCAA",
                "TCACTA"};

        assertThat(sentinel.isMutant(t4)).isEqualTo(false);




    }
  @Test
    public void todos5(){
        Sentinel sentinel = new Sentinel();

        String t5[]= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        assertThat(sentinel.isMutant(t5)).isEqualTo(true);



    }

}
