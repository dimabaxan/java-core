import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupUtility {
    public static void createBackup(String sourceDirPath) {
        File sourceDir = new File(sourceDirPath);
        File backupDir = new File("./backup");

        // Создаем папку backup, если ее нет
        if (!backupDir.exists()) {
            if (!backupDir.mkdir()) {
                System.out.println("Не удалось создать папку backup");
                return;
            }
        }

        // Получаем список файлов в исходной директории
        File[] files = sourceDir.listFiles();
        if (files == null) {
            System.out.println("Не удалось прочитать содержимое директории");
            return;
        }

        // Копируем файлы в папку backup
        for (File file : files) {
            if (file.isFile()) {
                try {
                    Path dest = new File(backupDir, file.getName()).toPath();
                    Files.copy(file.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("Ошибка копирования файла: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Резервное копирование завершено.");
    }

    public static void main(String[] args) {
        createBackup("./source"); // Укажите путь к директории
    }
}
