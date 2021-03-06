package simpleadapter.com.base.scope;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Scope
@Retention(RUNTIME)
public @interface ForApplication {
}
