// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
  production: false,
  keycloak: {
      RootUrl: 'https://enterprisearchitecture-test.digital.nhs.uk/auth',
      authServerUrl: 'https://enterprisearchitecture-test.digital.nhs.uk/auth',
      realm : 'ReferenceImplementations',
      client_secret : '709c79a1-7710-452f-859c-fb6edfb86027',
      client_id : 'ccri-cat',
      cookie_domain : 'localhost'
  },
  login : ''


};
