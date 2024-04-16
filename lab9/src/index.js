const { Builder, By, Key, until } = require('selenium-webdriver');
const assert = require('chai').assert;

async function addToCartAndCheckTest() {
    let driver = await new Builder().forBrowser('chrome').build();

    try {
        await driver.get('https://nsv.by/catalog/mobilnye-telefony/nothing-phone-2-12gb-256gb-belyj/');

        const addToCartButton = await driver.wait(until.elementLocated(By.css('.btn-lg.w_icons.to-cart.btn.btn-default.transition_bg.animate-load')), 10000);
        await addToCartButton.click();

        await driver.sleep(5000);

        const cartIcon = await driver.findElement(By.id('BasketHeaderIcon'));
        await cartIcon.click();

        const cartCountElement = await driver.wait(until.elementLocated(By.css('.cart-title-count')), 10000);

        const cartCountText = await cartCountElement.getText();

        const cartCount = parseInt(cartCountText);

        assert.strictEqual(cartCount, 1, 'Cart count should be equal to 1');

    } finally {
        await driver.quit();
    }
}

describe('NSV Tests', function() {
    this.timeout(50000);

    it('Cart count should be equal to 1 after adding an item to cart', async () => {
        await addToCartAndCheckTest();
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