package com.github.obase.mysql;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.github.obase.Page;

/**
 * Spring-mysqlclient core interface, which provides CRUD its bulk form @Table class.
 * 
 * <dl>
 * <dt>MysqlClient there are two important realization:
 * <dd>MysqlClientPlatformTransactionImpl with the Spring container-managed transaction to perform JDBC operation
 * <dd>MysqlConnectTransactionImpl manage its own affairs Connection transaction
 * </dl>
 * 
 * @author hezhaowu
 * @since 0.9.1
 */
public interface MysqlClient {

	/**
	 * The initialization method mysqlclient
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	void init() throws Exception;

	/**
	 * Executive Connection callbacks.
	 * 
	 * @param callback
	 *            the callback object to invoke
	 * @return
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> T callback(ConnectionCallback<T> callback, Object... params) throws SQLException;

	/**
	 * Insert an object using INSERT INTO ... Syntax
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int insert(T tableObject) throws SQLException;

	<T> int insert(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Insert an object using INSERT IGNORE INTO ... Syntax
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int insertIgnore(T tableObject) throws SQLException;

	<T> int insertIgnore(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Insert an object using INSERT INTO ... Syntax, and return the generated key value.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return the generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R insert(T tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R insert(Class<?> tableType, T tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * Insert an object using INSERT IGNORE INTO ... Syntax, and return the generated key value.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return the generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R insertIgnore(T tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R insertIgnore(Class<?> tableType, T tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * Update an object using UPDATE ... SET Syntax
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int update(T tableObject) throws SQLException;

	<T> int update(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Update an object using REPLACE INTO ... Syntax
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int replace(T tableObject) throws SQLException;

	<T> int replace(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Update an object using REPLACE INTO ... Syntax, and return the generated key value.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return the generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R replace(T tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R replace(Class<?> tableType, T tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * Insert or Update an object using INSERT INTO ... ON DUPLICATE KEY UPDATE column=IFNULL(?,column) Syntax,
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int merge(T tableObject) throws SQLException;

	<T> int merge(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Insert or Update an object using INSERT INTO ... ON DUPLICATE KEY UPDATE column=IFNULL(?,column) Syntax, and return the generated key value.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return the generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R merge(T tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R merge(Class<?> tableType, T tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * Delete an object using DELETE FROM ... Syntax
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int delete(T tableObject) throws SQLException;

	<T> int delete(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Delete an object by keys using DELETE FROM ... Syntax, with the same order of declaration.
	 * 
	 * @param tableType
	 *            the class marked @Table annotation
	 * @param keys
	 *            the primary key values
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int deleteByKey(Class<T> tableType, Object... keys) throws SQLException;

	/**
	 * Select an object using SELECT ... FROM Syntax, and returns a completely new object.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return the record object if there is, otherwise return null
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> T select(T tableObject) throws SQLException;

	<T> T select(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Select an object using SELECT ... FROM Syntax, it will reuse the parameter object but not create a new one;
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return the record object if there is, otherwise return null
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> T select2(T tableObject) throws SQLException;

	<T> T select2(Class<?> tableType, T tableObject) throws SQLException;

	/**
	 * Select an object by keys using SELECT ... FROM Syntax, with the same order of declaration.
	 * 
	 * @param tableType
	 *            , any class marked @Table annotation.
	 * @param keys
	 *            , primary keys of the table
	 * @return the record object if there is, otherwise return null
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> T selectByKey(Class<T> tableType, Object... keys) throws SQLException;

	/**
	 * Select all object using SELECT ... FROM Syntax
	 * 
	 * @param tableType
	 *            any class marked @Table annotation.
	 * @return the record list of a table
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> List<T> selectAll(Class<T> tableType) throws SQLException;

	/**
	 * Select a range object set between [start,start+count) using SELECT ... FROM...LIMIT offset,count Syntax
	 * 
	 * @param tableType
	 *            any class marked @Table annotation.
	 * @param offset
	 * @param count
	 * @return the record list of a table
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> List<T> selectRange(Class<T> tableType, int offset, int count) throws SQLException;

	/**
	 * Select the first object using SELECT ... FROM...LIMIT 0,1 Syntax
	 * 
	 * @param tableType
	 *            any class marked @Table annotation.
	 * @return the record list of a table
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> T selectFirst(Class<T> tableType) throws SQLException;

	/**
	 * 
	 * @param tableType
	 *            any class marked @Table annotation.
	 * @param page
	 *            contain information for paging, such as offset, count, orderBy, orderDesc
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> void selectPage(Class<T> tableType, Page<T> page) throws SQLException;

	/**
	 * The batch operation form of insert method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int[] batchInsert(List<T> tableObject) throws SQLException;

	<T> int[] batchInsert(T[] tableObject) throws SQLException;

	<T> int[] batchInsert(Class<?> tableType, List<T> tableObject) throws SQLException;

	<T> int[] batchInsert(Class<?> tableType, T[] tableObject) throws SQLException;

	/**
	 * The batch operation form of insertIgnore method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int[] batchInsertIgnore(List<T> tableObject) throws SQLException;

	<T> int[] batchInsertIgnore(T[] tableObject) throws SQLException;

	<T> int[] batchInsertIgnore(Class<?> tableType, List<T> tableObject) throws SQLException;

	<T> int[] batchInsertIgnore(Class<?> tableType, T[] tableObject) throws SQLException;

	/**
	 * The batch operation form of insert method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @param generatedKeyType
	 *            the type of generated key value
	 * @return the generated key values
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R[] batchInsert(List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchInsert(T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchInsert(Class<?> tableType, List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchInsert(Class<?> tableType, T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * The batch operation form of insertIgnore method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @param generatedKeyType
	 *            the type of generated key value
	 * @return the generated key values
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R[] batchInsertIgnore(List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchInsertIgnore(T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchInsertIgnore(Class<?> tableType, List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchInsertIgnore(Class<?> tableType, T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * The batch operation form of update method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int[] batchUpdate(List<T> tableObject) throws SQLException;

	<T> int[] batchUpdate(T[] tableObject) throws SQLException;

	<T> int[] batchUpdate(Class<?> tableType, List<T> tableObject) throws SQLException;

	<T> int[] batchUpdate(Class<?> tableType, T[] tableObject) throws SQLException;

	/**
	 * The batch operation form of replace method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int[] batchReplace(List<T> tableObject) throws SQLException;

	<T> int[] batchReplace(T[] tableObject) throws SQLException;

	<T> int[] batchReplace(Class<?> tableType, List<T> tableObject) throws SQLException;

	<T> int[] batchReplace(Class<?> tableType, T[] tableObject) throws SQLException;

	/**
	 * The batch operation form of replace method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @param generatedKeyType
	 *            the type of generated key value
	 * @return a list of generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R[] batchReplace(List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchReplace(T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchReplace(Class<?> tableType, List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchReplace(Class<?> tableType, T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * The batch operation form of merge method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int[] batchMerge(List<T> tableObject) throws SQLException;

	<T> int[] batchMerge(T[] tableObject) throws SQLException;

	<T> int[] batchMerge(Class<?> tableType, List<T> tableObject) throws SQLException;

	<T> int[] batchMerge(Class<?> tableType, T[] tableObject) throws SQLException;

	/**
	 * The batch operation form of merge method.
	 * 
	 * @param tableObject
	 *            any object whose class marked @Table annotation.
	 * @param generatedKeyType
	 *            the type of generated key value
	 * @return a list of generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R[] batchMerge(List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchMerge(T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchMerge(Class<?> tableType, List<T> tableObject, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchMerge(Class<?> tableType, T[] tableObject, Class<R> generatedKeyType) throws SQLException;

	/**
	 * The batch operation form of delete method.
	 * 
	 * @param tableObjects
	 *            any object whose class marked @Table annotation.
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int[] batchDelete(List<T> tableObjects) throws SQLException;

	<T> int[] batchDelete(T[] tableObjects) throws SQLException;

	<T> int[] batchDelete(Class<?> tableType, List<T> tableObjects) throws SQLException;

	<T> int[] batchDelete(Class<?> tableType, T[] tableObjects) throws SQLException;

	/**
	 * The batch operation form of deleteByKey method.
	 * 
	 * @param tableType
	 *            any object whose class marked @Table annotation.
	 * @param keys
	 *            the primary key values
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> int[] batchDeleteByKey(Class<T> tableType, List<Object[]> keys) throws SQLException;

	<T> int[] batchDeleteByKey(Class<T> tableType, Object[][] keys) throws SQLException;

	/**
	 * Execute the query represented by queryId and return all the records.
	 * 
	 * @param queryId
	 *            the query id
	 * @param elemType
	 *            the element type of result. it would be Object[] if null. It could not be array, enum, interface
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @return all the records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> List<T> query(String queryId, Class<T> elemType, Object params) throws SQLException;

	/**
	 * 
	 * Execute the query represented by queryId and return the records between [offset, offset+count)
	 * 
	 * @param queryId
	 *            the query id
	 * @param elemType
	 *            the element type of result. it would be Object[] if null. It could not be array, enum, interface
	 * @param offset
	 * @param count
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @return the records between [offset, offset+count)
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> List<T> queryRange(String queryId, Class<T> elemType, int offset, int count, Object params) throws SQLException;

	/**
	 * Execute the query represented by queryId and return the first record of result
	 * 
	 * @param queryId
	 *            the query id
	 * @param elemType
	 *            the element type of result. it would be Object[] if null. It could not be array, enum, interface
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @return the first record of result
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> T queryFirst(String queryId, Class<T> elemType, Object params) throws SQLException;

	/**
	 * Execute the query represented by queryId and return the page result
	 * 
	 * @param queryId
	 *            the query id
	 * @param elemType
	 *            the element type of result. it would be Object[] if null. It could not be array, enum, interface
	 * @param page
	 *            contain information for paging.
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T> void queryPage(String queryId, Class<T> elemType, Page<T> page, Object params) throws SQLException;

	/**
	 * Execute the update statement represented by queryId and return the number of affected records
	 * 
	 * @param updateId
	 *            the statement id
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	int execute(String updateId, Object params) throws SQLException;

	/**
	 * Execute the update statement represented by queryId and return the generated key value
	 * 
	 * @param updateId
	 *            the statement id
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @param generatedKeyType
	 *            the type of generated key value
	 * @return the generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<R> R execute(String updateId, Object params, Class<R> generatedKeyType) throws SQLException;

	/**
	 * The batch operation form of execute method.
	 * 
	 * @param updateId
	 *            the statement id
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @return number of affected records
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 */
	<T> int[] batchExecute(String updateId, List<T> params) throws SQLException;

	<T> int[] batchExecute(String updateId, T[] params) throws SQLException;

	/**
	 * The batch operation form of execute method.
	 * 
	 * @param updateId
	 *            the statement id
	 * @param params
	 *            the parameters for query, it could be scalar value in JavaType, Map, List, or POJO
	 * @param generatedKeyType
	 *            the type of generated key value
	 * @return the generated key value
	 * @throws SQLException
	 *             if there are any database access error or statement execution failed
	 * 
	 * @author hezhaowu
	 * @since 0.9.1
	 */
	<T, R> R[] batchExecute(String updateId, List<T> params, Class<R> generatedKeyType) throws SQLException;

	<T, R> R[] batchExecute(String updateId, T[] params, Class<R> generatedKeyType) throws SQLException;

	<T> List<T> queryWithCollects(String queryId, Class<T> elemType, Map<String, Object> params) throws SQLException;

	<T> List<T> queryRangeWithCollects(String queryId, Class<T> elemType, int offset, int count, Map<String, Object> params) throws SQLException;

	<T> T queryFirstWithCollects(String queryId, Class<T> elemType, Map<String, Object> params) throws SQLException;

	<T> void queryPageWithCollects(String queryId, Class<T> elemType, Page<T> page, Map<String, Object> params) throws SQLException;

}