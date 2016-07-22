/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package simpleadapter.com.login;

import dagger.Component;
import simpleadapter.com.base.component.ActivityComponent;
import simpleadapter.com.base.component.ApplicationComponent;
import simpleadapter.com.base.scope.PerActivity;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = LoginModule.class)
public interface LoginComponent {
  void inject(LoginActivity loginActivity);
}