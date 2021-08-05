package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func readFile() ([]string, bool) {
	var lines []string
	fileHandle, error := os.Open("numbers.txt")
	if error != nil {
		return nil, false
	}
	defer fileHandle.Close()
	fileScanner := bufio.NewScanner(fileHandle)
	for fileScanner.Scan() {
		lines = append(lines, fileScanner.Text())
	}
	return lines, true
}

func writeFile(avg float64, what bool) bool {
	var op string
	if what {
		op = "lineAvg.txt"
	} else {
		op = "totalAvg.txt"
	}
	fileHandle, err := os.OpenFile(op,
		os.O_APPEND|os.O_CREATE|os.O_WRONLY, 0644)
	if err != nil {
		return false
	}
	defer fileHandle.Close()
	_, err = fileHandle.WriteString(fmt.Sprintf("%0.2f\n", avg))
	if err != nil {
		fmt.Printf("Err :%v", err)
	}
	return true
}

func main() {
	lines, result := readFile()
	if !result {
		fmt.Println("Err !")
	} else {
		var sum float64 = 0
		var numberCount int
		var total float64
		for i := 0; i < len(lines); i++ {
			text := strings.Split(lines[i], "\t")
			for j := 0; j < len(text)-1; j++ {
				num, err := strconv.ParseFloat(text[j], 64)
				if err != nil {
					fmt.Println("Err")
				}
				sum += num
				numberCount++
			}
			avg := float64(sum) / float64((len(text) - 1))
			fmt.Printf("%d. satırın ortalaması %0.2f\n", i+1, avg)
			total += sum
			sum = 0
			writeFile(avg, true)
		}
		totalAvg := float64(total) / float64(numberCount)
		fmt.Printf("\nToplam ortalama %0.2f", totalAvg)
		writeFile(totalAvg, false)
	}

}
