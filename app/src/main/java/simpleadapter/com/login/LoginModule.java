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

import dagger.Module;
import dagger.Provides;
import simpleadapter.com.base.interactor.UseCase;
import simpleadapter.com.base.scope.PerActivity;
import simpleadapter.com.base.thread.PostExecutionThread;
import simpleadapter.com.base.thread.ThreadExecutor;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class LoginModule {

  public LoginModule() {}

  @Provides @PerActivity UseCase provideLoginUseCase(LoginRepository userRepository,
                                                     ThreadExecutor threadExecutor,
                                                     PostExecutionThread postExecutionThread) {
    return new LoginCase(userRepository, threadExecutor, postExecutionThread);
  }

  @Provides @PerActivity LoginApiRequester provideLoginApiRequester() {
    return new LoginApiRequesterImpl();
  }

  @Provides @PerActivity LoginRepository provideLoginRepository(LoginApiRequester apiRequester) {
    return new LoginRepositoryImpl(apiRequester);
  }
}