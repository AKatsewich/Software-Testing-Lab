const { assert } = require('chai');  
const app = require('../app.js');


describe('Triangle', function() {
    it('should return false when all values are zeros', () => {
        assert.isFalse(app.check(0,0,0),'Triangle with zero length sides should not exist');
    });
    it('should return false on one any argument as a string', () => {
        assert.isFalse(app.check('Sanyok',2,3),'Triangle side as a string accepted');
    });
    it('should return true on valid triangle input', () => {
        assert.isTrue(app.check(2,3,4),'Valid triangle wasn\'t accepted');
    });
    it('should return false on not enough arguments', () => {
        assert.isFalse(app.check(2,5),'Not enough arguments accepted');
    });
    it('should return true on all equal values', () => {
        assert.isTrue(app.check(7,7,7),'Equilateral triangle was rejected');
    });
    it('should not accept negative values', () => {
        assert.isFalse(app.check(-2,3,4),'Negative side accepted');
    });
    it('should return false on any argument as zero', () => {
        assert.isFalse(app.check(2,3,0),'Zero value accepted');
    });
    it('should return false on all string inputs', () => {
        assert.isFalse(app.check('7','7','7'),'Inputs as string were accepted');
    });
    it('should not accept any negative values', () => {
        assert.isFalse(app.check(-7,-7,-7),'Negative sides accepted');
    });
    it('should accept float values', () => {
        assert.isTrue(app.check(2.3,3.3,4.3),'Float values rejected');
    });
  });