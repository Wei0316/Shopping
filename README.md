# Shopping - 購物系統

這是一個使用 Java JFrame (Swing) 和 MySQL 建立的桌面購物系統，提供使用者瀏覽商品、加入購物車和創建訂單的功能。

## 功能

* **商品瀏覽：** 使用者可以瀏覽商品列表，查看商品名稱、價格和描述。
* **加入購物清單：** 使用者可以將商品加入購物車。
* **購物清單管理：** 使用者可以查看購物車內容，修改商品數量或移除商品。
* **訂單創建：** 使用者可以創建訂單，系統會將訂單資訊儲存到 MySQL 資料庫。
* **MySQL 資料庫：** 使用 MySQL 資料庫儲存商品、使用者和訂單資訊。

## 技術棧

* Java 11 (JDK 11)
* JFrame (Swing) - 用於建立圖形化使用者介面
* MySQL - 用於資料庫儲存

## 安裝說明

1.  **安裝 Java 11 (JDK 11)：**
    * 確保您的電腦已安裝 Java 11 或更高版本。您可以從 Oracle 官網下載 JDK 11。
2.  **安裝 MySQL：**
    * 確保您的電腦已安裝 MySQL 資料庫。您可以從 MySQL 官網下載安裝。
    * 啟動 MySQL 資料庫服務。
3.  **匯入 SQL 檔案：**
    * 從 [專案儲存庫](https://github.com/Wei0316/Shopping) 下載 `shopping.sql` 檔案。
    * 使用 MySQL 客戶端工具（例如 MySQL Workbench、phpMyAdmin 或命令列工具），登入您的 MySQL 伺服器。
    * 創建資料庫，例如 `shopping_db`。
    * 執行以下命令，將 `shopping.sql` 檔案匯入到 `shopping_db` 資料庫：

    ```bash
    mysql -u <使用者名稱> -p <資料庫名稱> < shopping.sql
    ```

    * 請將 `<使用者名稱>` 和 `<資料庫名稱>` 替換為您的 MySQL 使用者名稱和資料庫名稱。
4.  **下載 JAR 檔案：**
    * 從 [Release 頁面](https://github.com/Wei0316/Shopping/releases) 下載 `Shopping.jar` 檔案。
5.  **執行 JAR 檔案：**
    * 雙擊 `Shopping.jar` 檔案即可執行。

## 資料庫設定

1.  開啟 `src/main/java/DatabaseConnection.java` 檔案。
2.  修改以下變數，設定您的 MySQL 資料庫連接資訊：

```java
private static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
