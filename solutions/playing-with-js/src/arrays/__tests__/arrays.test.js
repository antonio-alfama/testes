const arrayImplementations = require('../arrays');

describe('arrays', () => {
    it('should add the given item to the array', () => {
        const testArray = [1, 2, 3];
        const item = 4;

        expect(arrayImplementations.add(testArray, item)).toEqual([1, 2, 3, 4]);
    });

    it('should add the given item at the start of the array', () => {
        const testArray = [1, 2, 3];
        const item = 4;

        expect(arrayImplementations.prepend(testArray, item)).toEqual([
            4,
            1,
            2,
            3,
        ]);
    });

    it('should remove the item from the array', () => {
        const testArray = [1, 2, 3, 4, 3];
        const item = 3;

        expect(arrayImplementations.remove(testArray, item)).toEqual([1, 2, 4]);
    });

    it('should find the index of the given item', () => {
        const testArray = [1, 2, 3];
        const item = 3;

        expect(arrayImplementations.findIndex(testArray, item)).toBe(2);
    });

    it('should sum all the items of the given array', () => {
        const testArray = [1, 2, 3, 4, 3];

        expect(arrayImplementations.sum(testArray)).toBe(13);
    });

    it('should concatenate two arrays', () => {
        const testArray = [1, 2, 3, 4];

        expect(arrayImplementations.concat(testArray, testArray)).toEqual([
            1,
            2,
            3,
            4,
            1,
            2,
            3,
            4,
        ]);
    });

    it('should compare two arrays for equality', () => {
        const testArrayA = [1, 2, 3, 4];
        const testArrayB = [1, 2, 3, 4];
        const testArrayC = [1, 2, 4];

        expect(arrayImplementations.isEqual(testArrayA, testArrayB)).toBe(true);
        expect(arrayImplementations.isEqual(testArrayA, testArrayC)).toBe(
            false
        );
    });

    it('should reverse the array', () => {
        const testArray = [1, 2, 3, 4];

        expect(arrayImplementations.reverse(testArray)).toEqual([4, 3, 2, 1]);
    });

    it('should insert an item in the array at the specific position', () => {
        const testArray = [1, 2, 3];
        const item = 'potato';
        const index = 2;

        expect(arrayImplementations.insert(testArray, item, index)).toEqual([
            1,
            2,
            'potato',
            3,
        ]);
    });

    it('should return an array filled with the item of the given length', () => {
        const length = 3;
        const item = 'a';

        expect(arrayImplementations.fill(length, item)).toEqual([
            'a',
            'a',
            'a',
        ]);
    });

    it('should remove all the falsy values from the array', () => {
        const testArray = [0, 1, 2, '', null, 4, false];

        expect(arrayImplementations.compact(testArray)).toEqual([1, 2, 4]);
    });

    it('should count the number of occurrences of the item in the array', () => {
        const testArray = [0, 1, 1, 1, 2, 3, 4, 5];
        const item = 1;

        expect(arrayImplementations.count(testArray, item)).toBe(3);
    });

    it('should multiply all the items on the array by the given number', () => {
        const testArray = [0, 1, 1, 1, 2, 3, 4, 5];
        const number = 2;

        expect(arrayImplementations.multiply(testArray, number)).toEqual([
            0,
            2,
            2,
            2,
            4,
            6,
            8,
            10,
        ]);
    });

    it('should find all the duplicates in the given array', () => {
        const testArray = [0, 0, 1, 2, 1, 2, 'potato', 'potato', 10, 11, 15];

        expect(arrayImplementations.findDuplicates(testArray)).toEqual([
            0,
            1,
            2,
            'potato',
        ]);
    });

    it('should find all the occurrences of an item on the given array', () => {
        const testArray = ['potato', 3, 7, 10, 3, 7, 15];
        const itemA = 3;
        const itemB = 7;

        expect(
            arrayImplementations.findAllOccurrences(testArray, itemA)
        ).toEqual([1, 4]);
        expect(
            arrayImplementations.findAllOccurrences(testArray, itemB)
        ).toEqual([2, 5]);
    });

    it('should correctly parse params of the given URL', () => {
        const url = 'www.mindera.com?a=1&b=2,3&c=4,5';

        expect(arrayImplementations.parseParams(url)).toEqual({
            a: 1,
            b: [2, 3],
            c: [4, 5],
        });
    });
});
