function fn() {
// Global
    var env = karate.env; // get system property 'karate.env'
    var urlBase = 'https://api.trello.com'; // base url
    var contentType = ''; // content type
    var apiKey = ''; // key
    var apiToken = ''; // token
    var urlVideoGame = ''; // url video game

    karate.log('karate.env system property');

    if (!env) {
        env = 'dev';
    }
    if (env == 'dev') {
        // customize
        urlBase = 'https://api.trello.com';
        contentType = 'application/json';
        apiKey = 'c71a72f99c8168a14131facf2d533d0f';
        apiToken = 'ATTAa1ded3c3479a2ef8b9235d03dc638ee2c7b1abcdd34bd401704bc8e32b2cdcb671DCD2BB';
        urlVideoGame = 'https://videogamedb.uk';

    } else if (env == 'cert') {
        // customize
        urlBase = 'https://api.trello.com';
        contentType = 'application/json';
        apiKey = 'c71a72f99c8168a14131facf2d533d0f';
        apiToken = 'ATTAa1ded3c3479a2ef8b9235d03dc638ee2c7b1abcdd34bd401704bc8e32b2cdcb671DCD2BB';
        urlVideoGame = 'https://videogamedb.uk';
    }

    var config = {
        env: env,
        urlBase: urlBase,
        contentType: contentType,
        apiKey: apiKey,
        apiToken: apiToken,
        urlVideoGame: urlVideoGame
    }
    return config;
}