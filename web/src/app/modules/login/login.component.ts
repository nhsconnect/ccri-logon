import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {KeycloakService} from '../../service/keycloak.service';
import {AppConfigService} from "../../service/app-config.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  logonRedirect: string = undefined;

  subscription: any;

  jwt: any;

  constructor(
              private router: Router,
              private activatedRoute: ActivatedRoute,
              public keycloakService: KeycloakService,
              private appConfig: AppConfigService
    ) {
  }

  // https://symbiotics.co.za/integrating-keycloak-with-an-angular-4-web-application/


  ngOnInit() {

      this.logonRedirect = this.activatedRoute.snapshot.queryParams['afterAuth'];

      if (this.appConfig.getConfig() !== undefined) {
          this.keycloakInit();
      } else {
          this.appConfig.getInitEventEmitter().subscribe( ()=> {
              this.keycloakInit();
              }
          )
      }

  }

  keycloakInit() {
      this.keycloakService.init()
          .then(() => {

              this.onKeyCloakComplete();
          })
          .catch(e => console.log('rejected'));


  }

  onKeyCloakComplete() {
    // Check logged in or login
    this.keycloakService.getToken().then(() => {

        // Set up a redirect for completion of OAuth2 login
        // This should only be called if OAuth2 has not been performed


/*
          this.subscription = this.fhirService.getOAuthChangeEmitter()
            .subscribe(item => {
              console.log('The Call back ran');
              this.router.navigate(['ping']);
            });
  */
          this.performLogins();

      }
    );
  }

  performLogins(): void {

    // console.log('Perform logins');

      // Set a call back for the CookieService
      this.keycloakService.getCookieEventEmitter()
          .subscribe(item => {
             // console.log('Cookie event '+this.logonRedirect);
              if (this.logonRedirect !== undefined) {
                window.location.href = this.logonRedirect;
              } else {
              // Should always be a logon redirect  this.fhirService.authoriseOAuth2();
              }
            }
          );

      this.keycloakService.setCookie();

  }




}
