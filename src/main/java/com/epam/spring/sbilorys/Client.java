package com.epam.spring.sbilorys;


import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Client implements AbstractClient{

    @Getter
    @NonNull
    private int id;
    @NonNull
    private String name;
    private String greeting;
}
