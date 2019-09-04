package com.example.mvpwithannotation.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * @date 2019/9/4 9:54
 * @author BoXun.Zhao
 * @description
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPresenter {
}
