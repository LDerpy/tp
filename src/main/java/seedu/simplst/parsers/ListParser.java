package seedu.simplst.parsers;

import seedu.simplst.Regex;
import seedu.simplst.Warehouse;
import util.exceptions.WrongCommandException;

public class ListParser extends CommandParser {
    public ListParser(Warehouse warehouse) {
        super(warehouse);
    }

    protected void init_extract_params() {
        Regex regexMatch;
        String regex;
        regex = "(?<flag>[og])/";
        regexMatch = new Regex(this.userInput, regex);
        this.matches = regexMatch.getGroupValues();
    }

    protected void extract_params() throws WrongCommandException {
        if (matches.get("flag").equals("o")) {
            // list orders with flag "o/"
            this.warehouse.listOrders();
        } else if (matches.get("flag").equals("g")) {
            // list goods with flag "g/"
            this.warehouse.listGoods(); // refers to inventory goods
        } else {
            // wrong command exception
            throw new WrongCommandException("list", true);
        }
    }
}
