import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, ErrorHandler, NgModule} from '@angular/core';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { TreeModule } from 'angular-tree-component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CookieModule, CookieService} from 'ngx-cookie';
import {LayoutModule} from '@angular/cdk/layout';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {KeycloakService} from './service/keycloak.service';
import {ErrorsHandler} from './service/errors-handler';
import {AppConfigService} from "./service/app-config.service";
import {LoginComponent} from './modules/login/login.component';
import {LogoutComponent} from './modules/logout/logout.component';


const appInitializerFn = (appConfig: AppConfigService) => {
  return () => {
    return appConfig.loadConfig();
  };
};


@NgModule({
  declarations: [
    AppComponent,

    LoginComponent,
    LogoutComponent

  ],
  entryComponents: [
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
      LayoutModule,
    CookieModule
      .forRoot(),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    TreeModule,


    AppRoutingModule

/*
    // Issue with https://github.com/Teradata/covalent/issues/1152
    CovalentDynamicFormsModule
*/
  ],
  providers: [
    AppConfigService,
    {
      provide: APP_INITIALIZER,
      useFactory: appInitializerFn,
      multi: true,
      deps: [AppConfigService]
    },

    CookieService,
    KeycloakService,
    {
      provide: ErrorHandler,
      useClass: ErrorsHandler,
    }

  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
