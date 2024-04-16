const {Builder, By, Key, until} = require('selenium-webdriver');
const assert = require('chai').assert;

async function searchAndCheckTest() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('https://nsv.by/');

        const searchInput = await driver.findElement(By.id('title-search-input_fixed'));
        await searchInput.sendKeys('Apple', Key.ENTER);

        await driver.wait(until.urlContains('Apple'), 10000);

        const currentUrl = await driver.getCurrentUrl();
        assert.include(currentUrl.toLowerCase(), 'apple', 'URL should contain the word "Apple"');

    } finally {
        await driver.quit();
    }
}

describe('NSV Tests', function() {
    this.timeout(50000);

    it('URL should contain the word "Apple" after search', async () => {
        await searchAndCheckTest();
    });
});

async function noveltiesTest() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('https://nsv.by/');
        
        const noveltiesLink = await driver.findElement(By.css('a.link_to_category.link_to_new_items'));
        await noveltiesLink.click();

        await driver.wait(until.elementsLocated(By.className('text_sticker')), 20000);
        
        const stickers = await driver.findElements(By.className('text_sticker'));
        assert.isTrue(stickers.length >= 3, 'There are at least three "text_sticker" divs on the page.');

        const thirdStickerText = await stickers[2].getText();
        assert.include(thirdStickerText, 'Новинка', 'The third "text_sticker" div contains "Новинка"');

    } finally {
        await driver.quit();
    }
}

describe('NSV Tests', function() {
    this.timeout(30000);

    it('Novelties section should highlight new items correctly', async () => {
        await noveltiesTest();
    });
});