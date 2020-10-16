package net.xx.sqlFormater.filter.dialec.kingbase;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.xx.sqlFormater.database.dialec.kingbase.KingbaseDatabaseBean;
import net.xx.sqlFormater.filter.dialec.AbsStandardFilterReadable;
import net.xx.sqlFormater.statement.StandardStatement;

public final class KingbasStandardFilterReadableBean extends AbsStandardFilterReadable {

	@Override
	public void pretreatment() {}
	
	private StandardStatement mStandardStatement;
	
	@Override
	public StandardStatement getStandardStatement() {
		return mStandardStatement;
	}
	
	@Override
	public void setStandardStatement(StandardStatement standardStatement) {
		mStandardStatement = standardStatement;
	}

	@Override
	protected void doPushEqualDate(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushEqual(table, column, formater.format(value));
	}

	@Override
	protected void doPushEqualDateTime(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushEqual(table, column, formater.format(value));
	}

	@Override
	protected void doPushLargeThenDate(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushLargeThen(table, column, formater.format(value) + " 00:00:00");
	}

	@Override
	protected void doPushLargeThenDateAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushLargeThenAndNull(table, column, formater.format(value) + " 00:00:00");
	}

	@Override
	protected void doPushLargeThenDateTime(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushLargeThen(table, column, formater.format(value));
	}

	@Override
	protected void doPushLargeThenDateTimeAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushLargeThenAndNull(table, column, formater.format(value));
	}

	@Override
	protected void doPushSmallThenDate(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushSmallThen(table, column, formater.format(value) + " 23:59:59");
	}

	@Override
	protected void doPushSmallThenDateAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushSmallThenAndNull(table, column, formater.format(value) + " 23:59:59");
	}

	@Override
	protected void doPushSmallThenDateTime(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushSmallThen(table, column, formater.format(value));
	}

	@Override
	protected void doPushSmallThenDateTimeAndNull(String table, String column, Date value) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushSmallThenAndNull(table, column, formater.format(value));
	}

	@Override
	protected void doPushBetweenDate(String table, String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATE);
		pushBetween(table, column, formater.format(start) + " 00:00:00", formater.format(end) + " 23:59:59");
	}

	@Override
	protected void doPushBetweenDateTime(String table, String column, Date start, Date end) {
		final SimpleDateFormat formater = new SimpleDateFormat(KingbaseDatabaseBean.PATTERN_DATETIME);
		pushBetween(table, column, formater.format(start), formater.format(end));
	}

	private void pushEqual(String table, String column, String value) {
		pushCondition(table, column, "= ?");
		pushRawArg(value);
	}

	private void pushLargeThen(String table, String column, String value) {
		pushCondition(table, column, ">= ?");
		pushRawArg(value);
	}

	private void pushLargeThenAndNull(String table, String column, String value) {
		final StringBuilder sql = new StringBuilder();
		sql.append("(");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" is null or ");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" >= ?)");
		pushRawCondition(sql.toString());
		pushRawArg(value);
	}

	private void pushSmallThen(String table, String column, String value) {
		pushCondition(table, column, "<= ?");
		pushRawArg(value);
	}

	private void pushSmallThenAndNull(String table, String column, String value) {
		final StringBuilder sql = new StringBuilder();
		sql.append("(");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" is null or ");
		sql.append(getOpenQuote());
		sql.append(table);
		sql.append(getCloseQuote());
		sql.append(".");
		sql.append(getOpenQuote());
		sql.append(column);
		sql.append(getCloseQuote());
		sql.append(" <= ?)");
		pushRawCondition(sql.toString());
		pushRawArg(value);
	}

	private void pushBetween(String table, String column, String start, String end) {
		pushCondition(table, column, "between ? and ?)");
		pushRawArg(start);
		pushRawArg(end);
	}

}
