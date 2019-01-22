export const environment = {
  production: true,
  keycloak: {
    RootUrl: 'KEYCLOAK_AUTH_URL',
    authServerUrl: 'KEYCLOAK_SERVER_URL',
    realm : 'ReferenceImplementations',
    client_secret : 'KEYCLOAK_CLIENT_SECRET',
    client_id : 'ccri-cat',
    cookie_domain: 'CAT_COOKIE_DOMAIN'
  }
};
