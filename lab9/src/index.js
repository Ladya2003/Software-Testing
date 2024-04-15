const {Builder, By, Key, until} = require('selenium-webdriver');
const assert = require('chai').assert;

async function mainPageTitleTest(){
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('https://nsv.by/');
        const title = await driver.findElement(By.css('h1')).getText();
        assert.include(title, 'Сеть салонов НА\'СВЯЗИ!', 'Заголовок присутствует на главной странице');
    } finally {
        await driver.quit();
    }
}

describe('NSV Tests', function(){
    this.timeout(30000); 

    it('Main page should have the correct title', async () => {
        await mainPageTitleTest();
    });
});



async function contactPageTest(){
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('https://nsv.by/');
        await driver.findElement(By.linkText('Контакты')).click();
        await driver.wait(until.elementLocated(By.className('ga_ym_t')), 20000);
        const phone = await driver.findElement(By.className('ga_ym_t')).getText();
        assert.include(phone, '8029', 'Номер телефона отображается на странице контактов');
    } finally {
        await driver.quit();
    }
}

describe('NSV Tests', function(){
    this.timeout(30000); 

    it('Contact page should display a phone number', async () => {
        await contactPageTest();
    });
});
