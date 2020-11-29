package com.github.jsonzou.jmockdata;

import io.bloco.faker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Faker faker = new Faker("zh-CN");
        List<String> names = new ArrayList<>();
        for (int i=0;i<10;i++){
            names.add(faker.name.name());
        }

        faker.pickRandom.fromArray(names.toArray());
        //faker.

        MockConfig mockConfig = new MockConfig().globalConfig()
//                .pickArray(names)
                .longRange(100000, 900000)
                .subConfig("name")
                .stringSeed("张三","李四","王五","赵六")
                .sizeRange(1,1)
                .subConfig("tags")
                .pickArray(names)
                .sizeRange(1,5)
                .globalConfig()
                .sizeRange(0,5);

        List<SimpleItem> items = new ArrayList<>();
        for (int i=0;i<10;i++){
            items.add(JMockData.mock(SimpleItem.class, mockConfig));
        }
        System.out.println(items.toString());


//        Pipeline p = Pipeline.create();
//        p.readFrom(TestSources.itemStream(10))
//                .withoutTimestamps()
//                .filter(event -> event.sequence() % 2 == 0)
//                .setName("filter out odd numbers")
//                .writeTo(Sinks.logger());
//
//        JetInstance jet = Jet.newJetInstance();
//
//        jet.newJob(p).join();
    }
}
